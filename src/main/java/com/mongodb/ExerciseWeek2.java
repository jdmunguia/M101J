package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

/**
 * Created by dmunguia on 1/23/17.
 */
public class ExerciseWeek2 {


    public static void main(String[] args) {
        MongoClient client = new MongoClient();

        MongoDatabase db = client.getDatabase("students");
        MongoCollection<Document> collection = db.getCollection("grades");


        for (int i = 0; i < 200; i++) {
            Bson filter = and(eq("student_id",i),eq("type","homework"));
            Document selDoc =collection.find(filter).sort(Sorts.ascending("score")).first();

            collection.deleteOne(selDoc);
        }

    }
}
