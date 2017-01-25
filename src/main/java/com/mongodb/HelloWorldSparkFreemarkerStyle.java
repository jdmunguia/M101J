package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmunguia on 1/12/17.
 */
public class HelloWorldSparkFreemarkerStyle {

    public static void main(String... args) {

        //Spark.get("/hello", (req, res) -> "Hello World");
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        Spark.get(new Route("/") {

            @Override
            public Object handle(final Request request, final Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");

                    Map<String, Object> helloMap = new HashMap<String, Object>();

                    helloMap.put("name", "Damian");

                    helloTemplate.process(helloMap, writer);


                } catch (IOException | TemplateException e) {
                    halt(500);
                    e.printStackTrace();
                }

                return writer;
            }
        });
    }
}
