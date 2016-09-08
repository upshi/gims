package com.yiheidaodi.gims.service;

import com.yiheidaodi.gims.model.User;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 09:21.
 */

public interface IUserService {

    List<User> userList();

    User userLogin(User user);
}
