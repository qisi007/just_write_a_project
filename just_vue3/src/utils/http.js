/**
* @name axios拦截器封装
* @description 根据不同环境去配置基础请求路径
* @version 2022-03-04 10:47:44 星期五
*/

import axios from "axios";
import urlConfig from "../config/global";
const instance = axios.create({
    baseURL: urlConfig.axios.baseURL[process.env.NODE_ENV],
    timeout: urlConfig.axios.timeout,
})

instance.interceptors.request.use( (config) => {
    return config
}, ( error ) => {
    return Promise.reject(error)
})

instance.interceptors.response.use( ( res ) => {
    return res.data
}, (error) => {
    return Promise.reject(error)
})

export default instance


