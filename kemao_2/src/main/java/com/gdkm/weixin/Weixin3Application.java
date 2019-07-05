package com.gdkm.weixin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gdkm.weixin.domain.InMessage;
@SpringBootApplication
@ComponentScan("com.gdkm")
public class Weixin3Application implements CommonsConfig {

	public static void main(String[] args) {
		SpringApplication.run(Weixin3Application.class, args);
	}
}
