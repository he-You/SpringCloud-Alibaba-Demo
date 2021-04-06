package com.heyou.springcloud.common.utils;

import com.github.pagehelper.PageInfo;
import lombok.Data;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2021/4/6 下午11:15
 */
@Data
public class Result<T> {
    /**
     * 标志位
     */
    private boolean success;
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据集
     */
    private T data;
    private Page page;
    public Result() {
        this.success = false;
    }
    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
    public Result<T> setInfo(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.setData(data);
        return this;
    }

    public void setData(T data) {
        if(data instanceof PageInfo<?>) {
            PageInfo<?> pageInfo = (PageInfo<?>)data;
            this.page = new Page(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getPages(),pageInfo.getTotal());
            this.data = (T) pageInfo.getList();
        }else {
            this.data = data;
        }
    }
    public void setPageInfo(PageInfo<?> pageInfo) {
        this.page = new Page(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getPages(),pageInfo.getTotal());
    }

    public Result error(Integer errorCode, String message) {
        Result result = new Result();
        result.setMsg(message);
        result.setCode(errorCode);
        return result;
    }
}
