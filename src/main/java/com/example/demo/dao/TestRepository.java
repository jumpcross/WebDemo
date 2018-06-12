package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends JpaRepository<User,Long> {
    User findByUserNo(String userNo);
    Page<User> findAll(Pageable pageable);
}
