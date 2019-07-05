package com.gdkm.weixin.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdkm.weixin.library.domain.Book;

//这个接口跟MyBatis的Mapper接口是一个含义的，都是用来操作数据库的表。
@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	Page<Book> findByDisabledFalse(Pageable pageable);

	Page<Book> findByDisabledFalseAndNameContaining(String keyword, Pageable pageable);

}
