package com.gdkm.weixin.processors;

import com.gdkm.weixin.domain.text.EventInMessage;

public interface EventMessageProcessor {

	void onMessage(EventInMessage msg);
}
