package com.gdkm.weixin.menu.service;

import com.gdkm.weixin.menu.domain.SelfMenu;

public interface SelfMenuService {

	SelfMenu getMenu();

	void save(SelfMenu selfMenu);

}
