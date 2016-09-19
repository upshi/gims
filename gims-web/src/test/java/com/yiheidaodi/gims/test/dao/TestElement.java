package com.yiheidaodi.gims.test.dao;

import com.yiheidaodi.gims.model.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.data.mongodb.core.query.Criteria.where;


/**
 * gims com.yiheidaodi.gims.test.dao
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-29 18:57.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mongo.xml" })
public class TestElement {

    @Autowired
    MongoOperations mongoOps;

    @Test
    public void findById() {
        Element ele = mongoOps.findOne(new Query(where("id").is("57dfa805016351d620154d92")), Element.class);
        System.out.println("----------------------------------------");
        System.out.println(ele);
    }

    @Test
    public void empty() {
        System.out.println("-------------- TEST ---------------");
    }



}
