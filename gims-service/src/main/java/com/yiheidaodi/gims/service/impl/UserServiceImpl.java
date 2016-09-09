package com.yiheidaodi.gims.service.impl;

import com.yiheidaodi.gims.dao.IUserDao;
import com.yiheidaodi.gims.model.User;
import com.yiheidaodi.gims.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service.impl
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 09:21.
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> userList() {
        return userDao.getAllUsers();
    }

    @Override
    public User userLogin(User user) {
        return userDao.getUserByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    @Override
    public int checkUserName(String userName) {
        User user = userDao.getUserByUserName(userName);
        return user == null? 0 : 1;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void updatePassword(String userId, String password) {
        userDao.updatePassword(userId, password);
    }
}
