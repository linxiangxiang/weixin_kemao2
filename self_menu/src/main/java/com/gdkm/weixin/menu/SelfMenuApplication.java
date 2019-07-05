package com.gdkm.weixin.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.gdkm.weixin.CommonsConfig;

@SpringBootApplication
@ComponentScan("com.gdkm")
@EntityScan("com.gdkm")
public class SelfMenuApplication implements CommonsConfig {

	public static void main(String[] args) {
		SpringApplication.run(SelfMenuApplication.class, args);
	}
}