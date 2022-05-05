package com.example.just_java.domain;

import com.example.just_java.config.PageParam;
import io.swagger.annotations.ApiModelProperty;

public class QueryDTO extends PageParam {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty("姓名")
    private String name;
}
