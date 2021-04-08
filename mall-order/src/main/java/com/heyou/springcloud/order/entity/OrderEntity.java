package com.heyou.springcloud.order.entity;

import lombok.Data;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/8 下午11:11
 */
@Data
public class OrderEntity {
    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private String userId;
    /**
     * 商品编号
     */
    private String commodityCode;
    /**
     *
     */
    private Integer count;
    /**
     *
     */
    private Integer amount;

    public OrderEntity(Integer id, String userId, String commodityCode, Integer count, Integer amount) {
        this.id = id;
        this.userId = userId;
        this.commodityCode = commodityCode;
        this.count = count;
        this.amount = amount;
    }
}
