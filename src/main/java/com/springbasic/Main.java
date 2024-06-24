package com.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = "com.springbasic")
//@EnableAutoConfiguration
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetResponse hello(){
        GreetResponse res = new GreetResponse("Trong", List.of("Book", "Game", "Film"), new Pet("My Dieu", "11"));
        return res;
    }

    record Pet(String name, String age){}

    record GreetResponse(String name, List<String> fav, Pet pet){}
}
