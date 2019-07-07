package com.gdkm.weixin.library.controller;

import com.gdkm.weixin.library.domain.DebitList;
import com.gdkm.weixin.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/kemao/library/debit")
@SessionAttributes({ "debitList" })
public class DebitController {

	@Autowired
	private LibraryService libraryService;

	@RequestMapping
	public String add(@RequestParam("id") String id, WebRequest request) {
		DebitList debitList = (DebitList) request.getAttribute("debitList", WebRequest.SCOPE_SESSION);
		if (debitList == null) {
			debitList = new DebitList();
			request.setAttribute("debitList", debitList, WebRequest.SCOPE_SESSION);
		}
		libraryService.add(id, debitList);
		return "redirect:/kemao/library/debit/list";
	}

	@RequestMapping("list")
	public String list() {
		return "/WEB-INF/views/library/debit/list.jsp";
	}

	@RequestMapping("remove/{id}")
	public String remove(@PathVariable("id") String id, @SessionAttribute(name = "debitList") DebitList debitList) {
		this.libraryService.remove(id, debitList);
		return "redirect:/kemao/library/debit/list";
	}
}
