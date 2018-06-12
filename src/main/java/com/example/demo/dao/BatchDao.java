package com.example.demo.dao;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface BatchDao<T> {

    void batchUpdate(List<T> list);
    void batchInsert(List<T> list);
}
