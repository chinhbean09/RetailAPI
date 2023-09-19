package com.rs.retailstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//class tu tao de spring boot biet duoc day la class se khoi tao ra springboot nao
//se chua tat ca component va bin trong cai springbootApplication, khi run RetailStoreApplicion thi no se run app, se quet het tat ca
//cac class de inject vao context cua spring context, no se chua tat ca cac class ma ta da khai bao
@SpringBootApplication
public class RetailStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailStoreApplication.class, args);
    }

}
