package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.FeignUserService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consume")
public class ConsumerController {
@Autowired
private UserService userService;
@Autowired
    FeignUserService feignUserService;
//http://localhost:8088/consume?ids=1
@GetMapping
public List<User> consume(@RequestParam("ids") List<Long> ids)
{
    return this.userService.queryUserByIds(ids);
}
//http://localhost:8088/consume/feign
@GetMapping("/feign")
    public String testFeign(){
    return feignUserService.testFeign();
}
}