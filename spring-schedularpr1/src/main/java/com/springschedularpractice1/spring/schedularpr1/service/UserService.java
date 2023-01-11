package com.springschedularpractice1.spring.schedularpr1.service;

import com.springschedularpractice1.spring.schedularpr1.dao.UserDao;
import com.springschedularpractice1.spring.schedularpr1.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    Logger log= LoggerFactory.getLogger(UserService.class);
    //schedule a job to add object in DB(every 5 sec)
    @Scheduled(fixedRate = 5000)
    public void add2DBJob(){
        User user=new User();
        user.setName("User"+new Random().nextInt(374483));
        userDao.save(user);
        System.out.println("add service call in "+new Date().toString());

    }

    @Scheduled(cron="0/15 * * * * *")
    public void fetchDBJob(){
        List<User> users= userDao.findAll();
        System.out.println("fetch service call in "+new Date().toString());
        System.out.println("no of records fetched: "+users.size());
        log.info("users : ",users);
    }

}
