package com.yiheidaodi.gims.dao;

import com.yiheidaodi.gims.model.User;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 09:21.
 */

public interface IUserDao {

    List<User> getAllUsers();

    User getUserByUserNameAndPassword(String userName, String password);

    User getUserByUserName(String userName);

    void add(User user);

    void updatePassword(String userId, String password);

    User getUserById(String id);
}
