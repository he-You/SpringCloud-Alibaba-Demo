package com.heyou.springcloud.order.controller;

import com.heyou.springcloud.common.utils.Result;
import com.heyou.springcloud.order.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/8 下午11:08
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    /**
     * 根据用户id查询订单信息
     * @param userId
     * @return
     */
    @RequestMapping("/findOrderByUserId/{userId}")
    public Result<List<OrderEntity>> findOrderByUserId(@PathVariable("userId") Integer userId) {
        log.info("根据userId:"+userId+"查询订单信息");
        OrderEntity orderEntity0 = new OrderEntity(1,"1001","sku100230",200,1000);
        OrderEntity orderEntity1 = new OrderEntity(2,"1001","sku100231",200,1000);
        OrderEntity orderEntity2 = new OrderEntity(3,"1001","sku100232",200,1000);
        OrderEntity orderEntity3 = new OrderEntity(4,"1001","sku100233",200,1000);
        List<OrderEntity> orderEntities = Arrays.asList(orderEntity0,orderEntity1,orderEntity2,orderEntity3);
        Result<List<OrderEntity>> result = new Result<>();
        result.setCode(HttpStatus.OK.value());
        result.setData(orderEntities);
        result.setMsg(HttpStatus.OK.getReasonPhrase());
        return result;
    }
}
