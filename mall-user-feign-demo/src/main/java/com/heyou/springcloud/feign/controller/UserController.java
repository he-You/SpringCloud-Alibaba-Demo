package com.heyou.springcloud.feign.controller;

import com.heyou.springcloud.common.utils.Result;
import com.heyou.springcloud.feign.feign.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/24 下午5:46
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private OrderFeignService orderFeignService;

    @RequestMapping(value = "/findOrderByUserId/{id}")
    public Result findOrderByUserId(@PathVariable("id") Integer id) {
        //feign调用
        Result result = orderFeignService.findOrderByUserId(id);
        return result;
    }
}
