package com.example.just_java.config;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;

public class PageParam {
    @NotNull()
    @ApiModelProperty(value = "页码", example = "1")
    protected Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @NotNull()
    @ApiModelProperty(value="每页多少条", example = "10")
    protected Integer size;
}
