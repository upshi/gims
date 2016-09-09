package com.yiheidaodi.gims.test.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.yiheidaodi.gims.model.Address;
import com.yiheidaodi.gims.model.Dept;
import com.yiheidaodi.gims.model.User;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.data.mongodb.core.query.Criteria.where;


/**
 * gims com.yiheidaodi.gims.test.dao
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-27 10:09.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mongo.xml", "classpath:spring.xml" })
public class TestMongo {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoOperations mongoOps;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    // @Test
    public void testMongoJavaAPI() {
        MongoDatabase gims = mongoClient.getDatabase("gims");
        MongoCollection<Document> sheet2016 = gims.getCollection("sheet2016");

        Address addr = new Address("江苏", "南京", "栖霞区", "进取村153号", "210000");
        Person person = new Person(null, "王豫宁", 15, addr);
        //通过JSON工具把对象序列化成json字符串,再转化成Document对象进行插入操作。
        Document doc = Document.parse(JSON.toJSONString(person, SerializerFeature.WriteMapNullValue));
        //插入文档
        //collection.insertOne(doc);

        FindIterable<Document> documents = sheet2016.find();
        MongoCursor<Document> iterator = documents.iterator();
        System.out.println();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

    }

    // @Test
    public void testSpringDataMongo() {
        Address addr = new Address("江苏", "徐州", "沛县", "王店村", "216300");
        Person person = new Person(null, "王文静", 12, addr);

        mongoOps.insert(person);

        Person one = mongoOps.findOne(new Query(where("name").is("王文静")), Person.class);
        System.out.println();
        System.out.println(one);
        System.out.println();
    }


    // @Test
    public void getAllUsers() {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("gims").getCollection("user");
        MongoCursor<Document> iterator = userCollection.find().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    // @Test
    public void insertUser() {
        MongoCollection<Document> userCollection = mongoClient.getDatabase("gims").getCollection("user");
        Dept d = mongoOps.findOne(new Query(where("isCollege").is(1).and("name").is("计算机与通信学院").and("office").is("院办")), Dept.class);
        System.out.println("-----------------------------------");
        System.out.println(d);
        User user = new User(null, "zpp", passwordEncoder.encode("123456"), "宗培培", "18635102597", "412356536@163.com", d, User.ROLE_ADMIN);
        // Document doc = Document.parse(JSON.toJSONString(user, SerializerFeature.WriteMapNullValue));
        // userCollection.insertOne(doc);
        mongoOps.insert(user);
    }

    @Test
    public void empty() {
        System.out.println("-------------- TEST ---------------");
    }

    // @Test
    public void findUser() {
        User user = mongoOps.findOne(new Query(where("userName").is("zpp").and("password").is("123456")), User.class);
        System.out.println(user);
    }

    // @Test
    public void updatePassword() {
        User user = mongoOps.findOne(new Query(where("userName").is("zpp").and("password").is("123456")), User.class);
        WriteResult writeResult = mongoOps.updateFirst(new Query(where("id").is("57d14fda4b2adf2a68ad6dfd")), Update.update("name", "金保召"), User.class);
        System.out.println("---------------------------------------\n");
        System.out.println(writeResult);
    }

}
