package com.gdkm.weixin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController是满足RESTful风格的一种控制器实现，实际上它还是@Controller。
//但是@RestController只是返回内容，不返回视图（JSP、HTML）。
@RestController
//路径和类的映射关系
//<url-pattern> 用于映射URL和Servlet的关系
//如果多人共享一台服务器，把kemao_2改为姓名的拼音
@RequestMapping("/kemao_2/message/receiver")
public class MessageReceiverController {

	// 注意：控制器里面必须要有处理器方法（Handler Method）才能执行操作，才不会404
	// 处理GET请求，HTTP协议支持GET、POST、PUT、DELETE等请求方式，都有对应的注解
	@GetMapping
	public String echo(//
			@RequestParam("signature") String signature, //
			@RequestParam("timestamp") String timestamp, //
			@RequestParam("nonce") String nonce, //
			@RequestParam("echostr") String echostr//
	//
	) {
		return echostr;
	}
}