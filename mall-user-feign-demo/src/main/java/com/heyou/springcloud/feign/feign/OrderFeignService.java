package com.heyou.springcloud.feign.feign;

import com.heyou.springcloud.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/24 下午5:48
 */
@FeignClient(value = "mall-order",path = "/order")
public interface OrderFeignService {
    @RequestMapping("/findOrderByUserId/{userId}")
    Result findOrderByUserId(@PathVariable("userId") Integer userId);
}
