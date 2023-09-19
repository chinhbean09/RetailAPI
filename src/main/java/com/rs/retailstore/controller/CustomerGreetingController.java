package com.rs.retailstore.controller;

import com.rs.retailstore.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController //danh dau cho chung ta la da khai bao 1 bean voi annotation la @Controller va tra ve dang @Responsebody
@RequestMapping("/v1")//version cho api cua minh, khi ta dua vao duong dan /v1/greeting thi no se di vao api

public class CustomerGreetingController {
    private static final String greetingTemplate = "Hello, %s %s ";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")//khai bao getmapping de su sung phuong thuc get, cua ham greeting
    public Greeting greeting(@RequestParam(value="gender",defaultValue = "0") boolean gender,
                             @RequestParam(value="customerName", defaultValue = "Customer") String customerName){
    return Greeting.builder().id(counter.incrementAndGet())
            .content(String.format(greetingTemplate, gender ? "Mr.":"Ms.",customerName)).
            build();

    }
}
