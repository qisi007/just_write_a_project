//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.just_java.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(
    description = "响应数据体"
)
public class JsonResult {
    @ApiModelProperty(
        value = "是否成功",
        position = 0
    )
    private Boolean success;
    @ApiModelProperty(
        value = "提示信息",
        position = 1
    )
    private String message;
    @ApiModelProperty(
        value = "实际数据",
        position = 3
    )
    private Object data;
    @ApiModelProperty(
        value = "错误码",
        position = 2
    )
    private int error = -1;
    @ApiModelProperty(
        value = "实际数据总数",
        position = 4
    )
    private Long total;
    @ApiModelProperty(
        value = "可见列集合",
        position = 5
    )
    private List<String> columnAccessFields;

    private JsonResult() {
    }

    public static JsonResult of(boolean success, String successMessage, String failMessage) {
        JsonResult res = new JsonResult();
        res.setSuccess(success);
        res.setMessage(success ? successMessage : failMessage);
        return res;
    }

    public static JsonResult success(String message) {
        JsonResult res = new JsonResult();
        res.setSuccess(true);
        res.setMessage(message);
        return res;
    }

    public static JsonResult success(String message, Object data) {
        JsonResult res = new JsonResult();
        res.setSuccess(true);
        res.setMessage(message);
        res.setData(data);
        return res;
    }

    public static JsonResult success(String message, Object data, Long total) {
        JsonResult res = new JsonResult();
        res.setSuccess(true);
        res.setMessage(message);
        res.setData(data);
        res.setTotal(total);
        return res;
    }

    public static JsonResult fail(String message) {
        JsonResult res = new JsonResult();
        res.setSuccess(false);
        res.setMessage(message);
        return res;
    }

    public static JsonResult fail(String message, Object data) {
        JsonResult res = new JsonResult();
        res.setSuccess(false);
        res.setMessage(message);
        res.setData(data);
        return res;
    }

    public static JsonResult fail(String message, int error) {
        JsonResult res = new JsonResult();
        res.setSuccess(false);
        res.setMessage(message);
        res.setError(error);
        return res;
    }

    public static JsonResult fail(String message, int error, Object data) {
        JsonResult res = new JsonResult();
        res.setSuccess(false);
        res.setMessage(message);
        res.setError(error);
        res.setData(data);
        return res;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public int getError() {
        return this.error;
    }

    public Long getTotal() {
        return this.total;
    }

    public List<String> getColumnAccessFields() {
        return this.columnAccessFields;
    }

    public JsonResult setSuccess(final Boolean success) {
        this.success = success;
        return this;
    }

    public JsonResult setMessage(final String message) {
        this.message = message;
        return this;
    }

    public JsonResult setData(final Object data) {
        this.data = data;
        return this;
    }

    public JsonResult setError(final int error) {
        this.error = error;
        return this;
    }

    public JsonResult setTotal(final Long total) {
        this.total = total;
        return this;
    }

    public JsonResult setColumnAccessFields(final List<String> columnAccessFields) {
        this.columnAccessFields = columnAccessFields;
        return this;
    }

    public String toString() {
        return "JsonResult(success=" + this.getSuccess() + ", message=" + this.getMessage() + ", data=" + this.getData() + ", error=" + this.getError() + ", total=" + this.getTotal() + ", columnAccessFields=" + this.getColumnAccessFields() + ")";
    }
}
