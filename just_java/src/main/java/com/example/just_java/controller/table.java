package com.example.just_java.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("table")
public class table {
    @RequestMapping("list")
    public static String getTable () {
        return "成功";
    }

}
