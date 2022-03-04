package com.example.just_java.controller;


import com.example.just_java.common.response.ResponseDTO;
import com.example.just_java.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("table")
public class table {

    @Autowired
    private TableService tableService;

    @RequestMapping("list")
    public ResponseDTO getTable () {
        return tableService.getTableDate();
    }

}
