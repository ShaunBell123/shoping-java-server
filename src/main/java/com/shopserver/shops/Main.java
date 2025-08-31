package com.shopserver.shops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.out.println("Shopping Java Server is running!");
        SpringApplication.run(Main.class, args);
    }

}
