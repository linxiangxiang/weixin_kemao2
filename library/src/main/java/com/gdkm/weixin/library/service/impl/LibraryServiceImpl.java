package com.gdkm.weixin.library.service.impl;


import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gdkm.weixin.library.domain.Book;
import com.gdkm.weixin.library.domain.DebitList;
import com.gdkm.weixin.library.repository.BookRepository;
import com.gdkm.weixin.library.service.LibraryService;
@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Page<Book> search(String keyword, int pageNumber) {

		// 1.封装分页条件，因为是基于Spring Data的，所以Spring Data本身就提供了分页封装
		// 10 : 表示每页最多10条数据
		Pageable pageable = PageRequest.of(pageNumber, 10);

		// 2.利用关键字进行搜索，得到Page对象
		Page<Book> page;
		if (StringUtils.isEmpty(keyword)) {
			page = this.bookRepository.findByDisabledFalse(pageable);
		} else {

			page = this.bookRepository.findByDisabledFalseAndNameContaining(keyword, pageable);
		}
		return page;
	}

	@Override
	public void add(String id, DebitList debitList) {
		// 调用方法返回的对象，都可能为null，所以要养成一个习惯：尽量检查一下别人传递过来或者返回的对象是否为null
		if (debitList.getBooks() == null) {
			debitList.setBooks(new LinkedList<>());
		}
		// 1.检查debitList里面是否有id相同的图书，如果有则不能加入
		boolean exists = false;
		for (Book b : debitList.getBooks()) {
			if (b.getId().equals(id)) {
				exists = true;
				break;
			}
		}
		if (!exists) {


			// 2.根据id查询图书
			this.bookRepository
					// 根据id查询对象，可能找不到
					.findById(id)
					// 如果存在，则执行括号里面的代码
					// 3.加入借阅列表中
					.ifPresent(debitList.getBooks()::add);
		}
	}

	@Override
	public void remove(String id, DebitList debitList) {
		debitList.getBooks()
				// 把集合转换为流（Stream）对象，可以用于流式编程。
				.stream()
				// 过滤需要的数据，需要找到图书的id跟传入的id参数相同的图书
				// filter在没有执行find之前不会计算（在函数式编程里面这个叫做【延迟计算】）
				.filter(book -> book.getId().equals(id))
				// 找到过滤之后的第一个结果
				.findFirst()
				// 从集合里面删除找到的图书
				.ifPresent(debitList.getBooks()::remove);
	}
}
