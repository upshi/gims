package com.yiheidaodi.gims.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBTest {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("upshi");
        MongoCollection<Document> coll = db.getCollection("test");

        MongoCursor<Document> iterator = coll.find().iterator();
        while(iterator.hasNext()) {
            Document document = iterator.next();
            System.out.println(document.put("_id",document.get("_id").toString()));
            System.out.println(document.toJson());
        }

    }

}
