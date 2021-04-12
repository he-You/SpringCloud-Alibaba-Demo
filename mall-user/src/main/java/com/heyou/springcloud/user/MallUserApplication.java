package com.heyou.springcloud.user;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/12 下午11:03
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@EnableFeignClients
public class MallUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallUserApplication.class,args);
    }
}
