package com.example.demo.controller;


import com.example.demo.dao.TestRepository;
import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Iterator;

@Controller
//@RequestMapping("admin")
public class OmsBqExpressManOrderMVC {

    private static Logger logger = LoggerFactory
            .getLogger(OmsBqExpressManOrderMVC.class);
    @Autowired
    TestRepository testRepository;
    @RequestMapping(value = "/batteryService.html")
    public ModelAndView getBatteryApplyService2(ModelAndView mav, HttpSession session){
        mav.setViewName("test");
        return mav;
    }
    @ResponseBody
    @GetMapping("data")
    public User getDataTest(){
     Iterable<User> infos = testRepository.findAll();
        Iterator<User> infoIterator = infos.iterator();
        User user = null;
     while (infoIterator.hasNext()){
         user = infoIterator.next();
     }
        return user;
    }
@PostMapping("save")
    public String saveUser(@ModelAttribute(value = "user")  User user){
        testRepository.save(user);
        return  "success";
    }

}

