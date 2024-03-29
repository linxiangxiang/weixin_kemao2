package com.gdkm.weixin.library.controller;

import com.gdkm.weixin.library.domain.Book;
import com.gdkm.weixin.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/kemao/library")
public class IndexController {

	@Autowired
	private LibraryService libraryService;

	@RequestMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber, Model model) {
		Page<Book> page = this.libraryService.search(keyword, pageNumber);
		model.addAttribute("page", page);
		return "/WEB-INF/views/library/index.jsp";
	}
}
