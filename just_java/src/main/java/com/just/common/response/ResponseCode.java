package com.just.common.response;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ResponseCode {

    static {
        ResponseCodeContainer.register(ResponseCode.class, 0, 1000);
        ResponseCodeContainer.register(LoginResponseCodeConst.class, 1001, 1999);
    }

    public static final ResponseCode SUCCESS = new ResponseCode(200, "操作成功!", true);
    public static final ResponseCode ERROR_PARAM = new ResponseCode(101, "参数异常！");
    public static final ResponseCode ERROR_PARAM_ANY = new ResponseCode(102, "%s参数异常！");
    public static final ResponseCode SYSTEM_ERROR = new ResponseCode(111, "系统错误");
    public static final ResponseCode DEVELOPMENT = new ResponseCode(112, "此功能正在开发中");
    public static final ResponseCode NOT_EXISTS = new ResponseCode(113, "数据不存在");
    public static ResponseCode REQUEST_METHOD_ERROR = new ResponseCode(114, "请求方式错误");
    public static ResponseCode JSON_FORMAT_ERROR = new ResponseCode(115, "JSON格式错误");
    public static ResponseCode IMPORT_FAILURE_ERROR = new ResponseCode(116, "导入失败");
    public static ResponseCode REPEAT_ADD = new ResponseCode(117, "重复录入");

    protected int code;
    protected String message;
    protected boolean success;

    public ResponseCode() {}

    protected ResponseCode(int code, String msg) {
        super();
        this.code = code;
        this.message = msg;
        ResponseCodeContainer.put(this);
    }

    protected ResponseCode(int code, String msg, boolean success) {
        super();
        this.code = code;
        this.message = msg;
        this.success = success;
        ResponseCodeContainer.put(this);
    }

    protected ResponseCode(int code) {
        super();
        this.code = code;
        ResponseCodeContainer.put(this);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static void init() {
        log.info("ResponseCode init....");
    }

    @Slf4j
    private static class ResponseCodeContainer {
        private static final Map<Integer, ResponseCode> RESPONSE_CODE_MAP = new HashMap<>();
        private static final Map<Class<? extends ResponseCode>, int[]> RESPONSE_CODE_RANGE_MAP = new HashMap<>();

        private static void register(Class<? extends ResponseCode> clazz, int start, int end ) {
            if ( start > end ) {
                throw  new IllegalArgumentException("<ResponseDTO> start > end ");
            }

            if ( RESPONSE_CODE_RANGE_MAP.containsKey(clazz) ) {
                throw new IllegalArgumentException(String.format("<ResponseDTO> Class:%s alread exist", clazz.getSimpleName()));
            }

            RESPONSE_CODE_RANGE_MAP.forEach(( k, v ) -> {
                if ( (start>=v[0] && start <= v[1]) || (end >= v[0] && end <= v[1]) ) {
                    throw new IllegalArgumentException(String.format("<ResponseDTO> Class:%s 's id range[%d,%d] has " + "intersection with " + "class:%s",clazz.getSimpleName(), start, end, k.getSimpleName() ));
                }
            });

            RESPONSE_CODE_RANGE_MAP.put(clazz, new int[]{start, end});

//            Field[] fields = clazz.getFields();
//            System.out.print(fields.toString());
//            System.out.print(clazz);
//            if ( fields.length !=0 ) {
//                try {
//                    fields[0].get(clazz);
//                } catch (IllegalArgumentException | IllegalAccessException e) {
//                    log.error("", e);
//                }
//            }


        }

        public static void put(ResponseCode codeConst) {
            int[] idRange = RESPONSE_CODE_RANGE_MAP.get(codeConst.getClass());
            if (idRange == null) {
                throw new IllegalArgumentException(String.format("<ResponseDTO> Class:%s has not been registered!", codeConst.getClass().getSimpleName()));
            }
            int code = codeConst.code;
            if (code < idRange[0] || code > idRange[1]) {
                throw new IllegalArgumentException(String.format("<ResponseDTO> Id(%d) out of range[%d,%d], " + "class:%s", code, idRange[0], idRange[1], codeConst.getClass().getSimpleName()));
            }
            if (RESPONSE_CODE_MAP.keySet().contains(code)) {
                log.error(String.format("<ResponseDTO> Id(%d) out of range[%d,%d], " + "class:%s  code is repeat!", code, idRange[0], idRange[1], codeConst.getClass().getSimpleName()));
                System.exit(0);
            }
            RESPONSE_CODE_MAP.put(code, codeConst);
        }


    }


}
