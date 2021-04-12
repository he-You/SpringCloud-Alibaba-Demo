package com.heyou.springcloud.user.controller;

import com.heyou.springcloud.common.utils.Result;
import com.heyou.springcloud.user.feign.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/12 下午11:22
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderFeignService orderFeignService;

    @RequestMapping(value = "/findOrderByUserId/{id}")
    public Result findOrderByUserId(@PathVariable("id") Integer id) {
        log.info("根据userId:"+id+"查询订单信息");
        // RestTemplate调用
//        String url = "http://localhost:8020/order/findOrderByUserId/"+id;
//        Result result = restTemplate.getForObject(url,Result.class);

        //模拟ribbon实现
        //String url = getUri("mall-order")+"/order/findOrderByUserId/"+id;
        // 添加@LoadBalanced
//        String url = "http://mall-order/order/findOrderByUserId/"+id;
//        Result result = restTemplate.getForObject(url,Result.class);

        //feign调用
        Result result = orderFeignService.findOrderByUserId(id);

        return result;
    }
}
