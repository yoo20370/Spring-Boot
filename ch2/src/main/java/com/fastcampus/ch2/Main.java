package com.fastcampus.ch2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. 원격 프로그램 등록
// 2. URL과 메서드를 연결


// @Controller - 원격 프로그램 등록 애너테이션
@RestController
public class Main {
    // URL과 메서드를 연결
    @RequestMapping("/hello")
    public String main(String[] args) {
        return "Hello";
    }
}
