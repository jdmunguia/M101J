package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by dmunguia on 1/12/17.
 */
public class HelloWorldSparkStyle {

    public static void main(String... args){

        //Spark.get("/hello", (req, res) -> "Hello World");

        Spark.get( new Route("/"){

            @Override
            public Object handle(final Request request, final Response response){
                return "Hello World from spark";
            }
        });
    }
}
