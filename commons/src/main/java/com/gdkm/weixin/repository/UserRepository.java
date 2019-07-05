package com.gdkm.weixin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdkm.weixin.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	// 会自动根据方法生成SQL语句
	// select * from wx_user where open_id = ?
	User findByOpenId(String openId);
}
