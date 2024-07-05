/**
* @name 全局配置
* @version 2022-03-04 10:55:40 星期五
*/


export default {
    website: {
        title: 'JUST后台管理',
        logo: '../assets/images/logo.png'
    },
    axios: {
        baseURL: {
            development: 'http://localhost:10010',
            production: ''
        },
        timeout: 60000
    }
}