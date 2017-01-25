package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        MongoClient client = new MongoClient();

        MongoDatabase db = client.getDatabase("course");
        MongoCollection<Document> coll = db.getCollection("findTest");

        coll.drop();

        for (int i = 0; i < 10; i++) {

            coll.insertOne(new Document("x",i));
        }

        System.out.println("find one");

        Document doc = coll.find().first();
        System.out.println(doc);

        System.out.println("find all");

        List<Document> all = coll.find().into(new ArrayList<Document>());

        for(Document cur: all){
            System.out.println(cur);
        }

        System.out.println("find all with interaction");

        MongoCursor<Document> cursor = coll.find().iterator();

        while(cursor.hasNext()){
            Document cur = cursor.next();
            System.out.println(cur);
        }

        System.out.println("Count");

        System.out.println(coll.count());

    }
}
