package com.example.demo.entity;

import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable{
    private Integer totalCount;
    private Integer pageNum;
    private Integer numPerPage;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(Integer numPerPage) {
        this.numPerPage = numPerPage;
    }

}
