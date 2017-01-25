package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmunguia on 1/12/17.
 */
public class HelloWorldFreeMarkerStyle {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class,"/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String,Object> helloMap = new HashMap<String,Object>();

            helloMap.put("name","Damian");

            helloTemplate.process(helloMap,writer);

            System.out.println(writer);

        } catch (IOException| TemplateException e) {
            e.printStackTrace();
        }
    }
}
