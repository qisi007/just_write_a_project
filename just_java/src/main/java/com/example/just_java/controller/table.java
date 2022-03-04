package com.example.just_java.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("table")
public class table {
    @RequestMapping("list")
    public static String getTable () {
        return "{ success: true, data: [], code: 200, message: '成功' }";
    }

}
