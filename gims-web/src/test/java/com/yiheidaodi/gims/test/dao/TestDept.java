package com.yiheidaodi.gims.test.dao;

import com.yiheidaodi.gims.model.Dept;
import com.yiheidaodi.gims.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;


/**
 * gims com.yiheidaodi.gims.test.dao
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-29 18:57.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mongo.xml" })
public class TestDept {

    @Autowired
    MongoOperations mongoOps;

    // @Test
    public void addCollege() {
        Dept dept = new Dept(null, "教务处", "办公室1", 0);
        mongoOps.insert(dept);
    }

    // @Test
    public void updateCollege() {
        // mongoOps.updateFirst(new Query(where("name").is("计算与通信学院")), new Update().set("name", "计算机与通信学院"), Dept.class);
    }

    // @Test
    public void collegeList() {
        List<Dept> list = mongoOps.find(new Query(where("isCollege").is(1)), Dept.class);
        for(Dept d : list) {
            System.out.println(d);
        }
    }

    // @Test
    public void deptList() {
        List<Dept> list = mongoOps.find(new Query(where("isCollege").is(0).and("office").is("")), Dept.class);
        for(Dept d : list) {
            System.out.println(d);
        }
    }

    // @Test
    public void addUser() {
        Dept d = mongoOps.findOne(new Query(where("isCollege").is(1).and("name").is("计算机与通信学院").and("office").is("院办")), Dept.class);
        User user = new User(null, "zpp", "123456", "宗培培", "18652014930", "wqdwq@163.com", d, User.ROLE_COLLEGE);
        mongoOps.insert(user);
    }

    // @Test
    public void userList() {
        List<User> list = mongoOps.findAll(User.class);
        System.out.println(list.size());
    }



    @Test
    public void empty() {
        System.out.println("-------------- TEST ---------------");
    }



}
