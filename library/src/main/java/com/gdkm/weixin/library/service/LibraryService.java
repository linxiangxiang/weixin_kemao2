package com.gdkm.weixin.library.service;

import com.gdkm.weixin.library.domain.Book;
import com.gdkm.weixin.library.domain.DebitList;
import org.springframework.data.domain.Page;

public interface LibraryService {
	public Page<Book> search(String keyword, int pageNumber);

	public void add(String id, DebitList debitList);

	public void remove(String id, DebitList debitList);
}
