package com.just.controller;


import com.just.common.response.JsonResult;
import com.just.domain.QueryDTO;
import com.just.domain.TableDomain;
import com.just.service.TableService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("table")
public class table {

    @Autowired
    private TableService tableService;

    @ApiOperation(value = "获取表格数据")
    @GetMapping("list")
    public JsonResult getTable (@RequestParam Integer page, @RequestParam Integer size, QueryDTO queryDTO ) {
        Page helper = PageHelper.startPage(page, size);
        List<TableDomain> tableDomainList = tableService.getTableDate( queryDTO );
        return JsonResult.success("查询成功啊", tableDomainList, helper.getTotal());
    }

    @ApiOperation(value = "添加数据")
    @PostMapping("add")
    public  JsonResult addData ( @RequestBody TableDomain tableDomain ) {
        tableService.addData(tableDomain);
        return JsonResult.success("添加成功");
    }

    @ApiOperation(value = "根据id删除数据")
    @PostMapping("delete")
    public  JsonResult deleteData ( @RequestBody String id ) {
        tableService.deleteData(id);
        return JsonResult.success("删除成功");
    }

    @ApiOperation(value = "编辑数据")
    @PostMapping("edit")
    public  JsonResult editData ( @RequestBody TableDomain tableDomain ) {
        tableService.editData(tableDomain);
        return JsonResult.success("更新成功");
    }
}
