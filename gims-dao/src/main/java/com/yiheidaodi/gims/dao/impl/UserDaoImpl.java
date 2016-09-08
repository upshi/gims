package com.yiheidaodi.gims.dao.impl;

import com.yiheidaodi.gims.dao.IUserDao;
import com.yiheidaodi.gims.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;


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

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return mongoOps.findAll(User.class);
    }

    @Override
    public User getUserByUserNameAndPassword(String userName, String password) {
        User user = getUserByUserName(userName);
        if(user != null) {
            if(passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        return mongoOps.findOne(new Query(where("userName").is(userName)), User.class);
    }
}
