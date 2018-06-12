package com.example.demo.controller;


import com.example.demo.dao.TestRepository;
import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class WebController {

    private static Logger logger = LoggerFactory
            .getLogger(WebController.class);
    @Autowired
    TestRepository testRepository;
    @RequestMapping(value = "/getUser.html")
    public ModelAndView getUser(ModelAndView mav, HttpSession session,String userNo){
        //User user = testRepository.findByUserNo(userNo);

        User user = new User();
        user.setId(123);
        user.setUserName("test");
        user.setUserNo("123123");
        mav.addObject("user", user);
        mav.setViewName("test");
        return mav;
    }
    public String batchSave(){
        List<User> list = new ArrayList<>();
        list.add(new User());



        return "success";
    }
    @ResponseBody
    @GetMapping("/data")
    public Page<User> getDataTest(){
     Iterable<User> infos = testRepository.findAll();
        Iterator<User> infoIterator = infos.iterator();
        User user = null;
     while (infoIterator.hasNext()){
         user = infoIterator.next();
     }

        Page<User> users = testRepository.findAll(new PageRequest(1, 20));
     return users;
    }
    @ResponseBody
@PostMapping("/save")
    public String saveUser(@ModelAttribute(value = "user")  User user){
        testRepository.save(user);
        return  "success";
    }

}

