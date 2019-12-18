package com.example.demo.dao;

import com.example.demo.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDao {
@Autowired
private RestTemplate restTemplate;
@Autowired
    DiscoveryClient discoveryClient;
    @HystrixCommand(fallbackMethod = "fallback")
public User queryUserById(Long id){
    // 在没使用ribbon时的写法，application类中没有调用@loadbalanced
//    List<ServiceInstance> list = discoveryClient.getInstances("user-service");
//
//    String url = "http://"+list.get(0).getHost()+":"+list.get(0).getPort()+"/user/+" + id;
//    return this.restTemplate.getForObject(url, User.class);
    return this.restTemplate.getForObject("http://user-service/user/"+1,User.class);
}
    public User fallback(Long id) {
        return null;
    }
}