package com.yiheidaodi.gims.dao;


import com.yiheidaodi.gims.model.User;

public interface IUserDao {

	//通过手机号码查询用户
	User selectUserByMobilePhone(String mobilePhone);

}
