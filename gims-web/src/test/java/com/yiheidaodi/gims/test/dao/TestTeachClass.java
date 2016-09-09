package com.yiheidaodi.gims.test.dao;

import com.yiheidaodi.gims.model.TeachClass;
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
public class TestTeachClass {

    @Autowired
    MongoOperations mongoOps;

    // @Test
    public void insert() {
        TeachClass teachClass = new TeachClass(null, "计算机与通信学院", "2014", "", "");
        mongoOps.insert(teachClass);
    }

    // @Test
    public void getAllGrades() {
        List<TeachClass> teachClasses = mongoOps.find(new Query(where("college").is("计算机与通信学院").and("major").is("").and("clazz").is("")), TeachClass.class);
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        for(TeachClass t : teachClasses) {
            System.out.println(t);
        }
    }

    @Test
    public void empty() {
        System.out.println("-------------- TEST ---------------");
    }



}
