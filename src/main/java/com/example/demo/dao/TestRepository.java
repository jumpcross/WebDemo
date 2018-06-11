package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<User,Long> {
}
