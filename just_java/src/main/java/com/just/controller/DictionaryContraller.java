package com.just.controller;

import com.just.common.response.JsonResult;
import com.just.domain.DictionaryDomain;
import com.just.service.DictionaryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("dictionary")
public class DictionaryContraller {

    @Autowired
    DictionaryService dictionaryService;

    @ApiOperation( value = "根据类型获取字典" )
    @GetMapping("list")
    @ResponseBody
    public JsonResult getList (@RequestParam String type) {
        List<DictionaryDomain> dictionaryDomains = dictionaryService.getDictionary(type);
        return JsonResult.success("获取成功", dictionaryDomains);
    }
}
