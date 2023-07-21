package com.just.common.response;

public class ResponseDTO<T> {

    protected Integer code;

    protected String message;

    protected Boolean success;

    protected T data;

    public ResponseDTO() {
    }

    public ResponseDTO(ResponseCode responseCode, String message) {
        this.code = responseCode.getCode();
        this.message = message;
        this.success = responseCode.isSuccess();
    }

    public ResponseDTO(ResponseCode responseCode, T data) {
        super();
        this.code = responseCode.getCode();
        this.message = responseCode.getMsg();
        this.data = data;
        this.success = responseCode.isSuccess();
    }

    public ResponseDTO(ResponseCode responseCode, T data, String message) {
        super();
        this.code = responseCode.getCode();
        this.message = message;
        this.data = data;
        this.success = responseCode.isSuccess();
    }

    private ResponseDTO(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMsg();
        this.success = responseCode.isSuccess();
    }

    public ResponseDTO(ResponseDTO responseDTO) {
        this.code = responseDTO.getCode();
        this.message = responseDTO.getmessage();
        this.success = responseDTO.isSuccess();
    }

    public static <T> ResponseDTO<T> succ() {
        return new ResponseDTO(ResponseCode.SUCCESS);
    }

    public static <T> ResponseDTO<T> succData(T data, String message) {
        return new ResponseDTO(ResponseCode.SUCCESS, data, message);
    }

    public static <T> ResponseDTO<T> succData(T data) {
        return new ResponseDTO(ResponseCode.SUCCESS, data);
    }

    public static <T> ResponseDTO succmessage(String message) {
        return new ResponseDTO(ResponseCode.SUCCESS, message);
    }

    public static <T> ResponseDTO<T> wrap(ResponseCode codeConst) {
        return new ResponseDTO<>(codeConst);
    }

    public static <T> ResponseDTO<T> wrap(ResponseCode codeConst, T t) {
        return new ResponseDTO<T>(codeConst, t);
    }

    public static <T> ResponseDTO<T> wrap(ResponseCode codeConst, String message) {
        return new ResponseDTO<T>(codeConst, message);
    }

    public String getmessage() {
        return message;
    }

    public ResponseDTO setmessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseDTO setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseDTO setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" + "code=" + code + ", message='" + message + '\'' + ", success=" + success + ", data=" + data +
                '}';
    }
}
