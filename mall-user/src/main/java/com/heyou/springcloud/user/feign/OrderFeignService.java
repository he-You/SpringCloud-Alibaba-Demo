package com.heyou.springcloud.user.feign;

import com.heyou.springcloud.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/12 下午11:22
 */
@FeignClient(value = "mall-order",path = "/order")
public interface OrderFeignService {

    @RequestMapping(value = "/findOrderByUserId/{id}")
    Result findOrderByUserId(@PathVariable("id") Integer id);
}
