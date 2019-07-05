package com.gdkm.weixin.library.service;

import org.springframework.data.domain.Page;

import com.gdkm.weixin.library.domain.Book;
import com.gdkm.weixin.library.domain.DebitList;

public interface LibraryService {

	// Spring Data的Page对象表示一页数据
	public Page<Book> search(String keyword, int pageNumber);

	public void add(String id, DebitList debitList);

	public void remove(String id, DebitList debitList);
}
