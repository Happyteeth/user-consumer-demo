package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
@Autowired
private UserDao userDao;
    @Autowired
    private RestTemplate restTemplate;


public List<User> errorQueryByIds(List<Long> ids){
    return null;
}
    @HystrixCommand(fallbackMethod = "errorQueryByIds")
public List<User> queryUserByIds(List<Long> ids){
    List<User> users = new ArrayList<>();
    for (Long id : ids) {
        User user =this.userDao.queryUserById(id);
        users.add(user);
    }
    return users;
}
}
