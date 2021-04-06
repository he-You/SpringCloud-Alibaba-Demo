package com.heyou.springcloud.common.utils;

import lombok.Data;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/6 下午11:16
 */
@Data
public class Page {
    //当前页码
    //默认页码 1
    private Integer pageIndex = 1;

    //当前每页条数
    //默认每页条数
    private Integer pageSize = 10;

    //默认为1
    private Integer totalPage = 1;

    //默认1
    private Long totalNum = 1L;

    //默认排序方向
    //private String order = Direction.DESC.toString();

    //排序字段
    private String properties;

    public Page() {

    }

    public Page(Integer pageIndex, Integer pageSize, Integer totalPage, Long totalNum) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalNum = totalNum;
    }
}
