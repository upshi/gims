package com.yiheidaodi.gims.test.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.yiheidaodi.gims.model.Address;
import com.yiheidaodi.gims.model.Person;
import org.bson.Document;
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
 * 时间：2016-8-27 10:09.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mongo.xml" })
public class TestMongo {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoOperations mongoOps;

    @Test
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

    @Test
    public void testSpringDataMongo() {
        Address addr = new Address("江苏", "徐州", "沛县", "王店村", "216300");
        Person person = new Person(null, "王文静", 12, addr);

        mongoOps.insert(person);

        Person one = mongoOps.findOne(new Query(where("name").is("王文静")), Person.class);
        System.out.println();
        System.out.println(one);
        System.out.println();
    }

}
