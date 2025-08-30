package com.shopserver.shops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
        System.out.println("Shopping Java Server is running!");
        SpringApplication.run(DemoApplication.class, args);

        try (Context context = Context.create()) {

            SpringApplication.run(DemoApplication.class, args);

            Source src = Source.newBuilder("python", new File("src/python-resources/TescoScraper.py")).build();
            context.eval(src);

            Value pyClass = context.getBindings("python").getMember("TescoScraper");
            Value instance = pyClass.newInstance();
            Value result = instance.invokeMember("scrape", "Apple");
            System.out.println(result.asString());

        }

    }

}
