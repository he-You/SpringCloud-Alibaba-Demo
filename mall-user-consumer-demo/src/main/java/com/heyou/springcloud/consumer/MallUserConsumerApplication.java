package com.heyou.springcloud.consumer;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/6 下午11:04
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class MallUserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallUserConsumerApplication.class,args);
    }
}
