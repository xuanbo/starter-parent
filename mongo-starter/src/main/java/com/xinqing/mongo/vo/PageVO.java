package com.xinqing.mongo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页VO
 *
 * Created by xuan on 2018/3/22
 */
public class PageVO<T> implements Serializable {

    private Long total;
    private Integer limit;
    private List<T> data;

    public PageVO(Long total, Integer limit, List<T> data) {
        this.total = total;
        this.limit = limit;
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "total=" + total +
                ", limit=" + limit +
                ", data=" + data +
                '}';
    }
}
