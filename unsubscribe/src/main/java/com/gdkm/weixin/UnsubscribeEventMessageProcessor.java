package com.gdkm.weixin;

import java.util.Date;

import javax.transaction.Transactional;

import com.gdkm.weixin.domain.User;
import com.gdkm.weixin.domain.text.EventInMessage;
import com.gdkm.weixin.processors.EventMessageProcessor;
import com.gdkm.weixin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("unsubscribeMessageProcessor")
public class UnsubscribeEventMessageProcessor implements EventMessageProcessor {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public void onMessage(EventInMessage msg) {
		if (msg.getEvent().equals("unsubscribe")) {
			System.out.println("取消关注消息处理器: " + msg);
			User user = this.userRepository.findByOpenId(msg.getFromUserName());
			if (user != null) {
				user.setStatus(User.Status.IS_UNSUBSCRIBE);
				user.setUnsubTime(new Date());
			}
		}
	}
}
