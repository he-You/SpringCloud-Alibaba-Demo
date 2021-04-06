package com.heyou.springcloud.consumer.controller;

import com.heyou.springcloud.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/6 下午10:52
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/findOrderByUserId/{id}")
    public Result findOrderByUserId(@PathVariable("id") Integer id) {
        log.info("根据userId:"+id+"查询订单信息");
        // RestTemplate调用    负载均衡器 mall-order服务&选择一个去调用
        // RestTemplate扩展点  ClientHttpRequestInterceptor
        // ribbon  LoadBalancerInterceptor
        //  mall-order  ---->    localhost: 8020
        // http://localhost: 8020 /order/findOrderByUserId/1
        String url = "http://mall-order/order/findOrderByUserId/"+id;
        Result result = restTemplate.getForObject(url,Result.class);

        return result;
    }
}
