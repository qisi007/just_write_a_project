package com.example.just_java.controller;


import com.example.just_java.common.ResponseDTO;
import com.example.just_java.domain.TableDomain;
import com.example.just_java.mapper.TableMapper;
import com.example.just_java.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
