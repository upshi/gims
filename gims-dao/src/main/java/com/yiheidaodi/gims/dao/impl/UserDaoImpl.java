package com.yiheidaodi.gims.dao.impl;

import com.yiheidaodi.gims.dao.IUserDao;
import com.yiheidaodi.gims.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.dao.impl
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 15:26.
 */

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    MongoOperations mongoOps;

    @Override
    public List<User> getAllUsers() {
        return mongoOps.findAll(User.class);
    }
}
