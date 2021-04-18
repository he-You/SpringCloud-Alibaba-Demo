package com.heyou.springcloud.user.ribbon.rule;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义负载均衡策略
 *
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/18 下午4:30
 */
@Slf4j
public class NacosRandomWithWeightRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        DynamicServerListLoadBalancer loadBalancer = (DynamicServerListLoadBalancer)getLoadBalancer();
        String serviceName = loadBalancer.getName();
        NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
        try {
            // nacos基于权重的算法
            Instance instance = namingService.selectOneHealthyInstance(serviceName);
            return new NacosServer(instance);
        } catch (NacosException e) {
            log.error("获取服务实例异常:{}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
