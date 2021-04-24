package com.heyou.springcloud.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/24 下午6:11
 */
public class FeignAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 业务逻辑  模拟认证逻辑
        String access_token = UUID.randomUUID().toString();
        requestTemplate.header("Authorization",access_token);
    }
}
