package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="user-service")
// feign组件只是省略名字端口，通过配置方法无需手动拼接url  包括服务名称，还有地址（端口后的地址要写全）
public interface FeignUserService {
@GetMapping(value = "/user/testFeign")
    public String testFeign();
}
