package com.just;

import com.just.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JustJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustJavaApplication.class, args);
        System.out.println("启动成功");
    }


    @Bean
    public FilterRegistrationBean registerFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");
        bean.setFilter(new CorsConfig());
        return bean;
    }
}
