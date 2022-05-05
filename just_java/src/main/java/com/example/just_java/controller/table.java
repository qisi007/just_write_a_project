package com.example.just_java.controller;


import com.example.just_java.common.response.ResponseDTO;
import com.example.just_java.domain.QueryDTO;
import com.example.just_java.domain.TableDomain;
import com.example.just_java.service.TableService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("table")
public class table {

    @Autowired
    private TableService tableService;

    @ApiOperation(value = "获取表格数据")
    @PostMapping("list")
    @ResponseBody
    public ResponseDTO getTable ( QueryDTO queryDTO ) {


        return tableService.getTableDate( queryDTO );
    }
}
