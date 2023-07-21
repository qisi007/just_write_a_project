package com.just.domain;

import io.swagger.annotations.ApiModelProperty;

public class QueryDTO {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty("姓名")
    private String name;
}
