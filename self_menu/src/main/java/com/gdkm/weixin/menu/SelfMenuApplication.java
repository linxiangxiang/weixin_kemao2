package com.gdkm.weixin.menu;

import com.gdkm.weixin.CommonsConfig;
import com.gdkm.weixin.service.AccessTokenManager;
import com.gdkm.weixin.serviceImpl.AccessTokenManagerSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.gdkm")
@EntityScan("com.gdkm")
@ComponentScan("com.gdkm")
public class SelfMenuApplication implements CommonsConfig {

	public static void main(String[] args) {
		SpringApplication.run(SelfMenuApplication.class, args);
		AccessTokenManager access=new AccessTokenManagerSample();
	}
}
