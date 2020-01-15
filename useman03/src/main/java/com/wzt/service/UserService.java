package com.wzt.service;

import com.wzt.config.FeignConfig;
import com.wzt.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
                /*PROVIDE*/
@FeignClient(value = "ZULLFILTER",configuration = FeignConfig.class,fallback = UserServiceImpl.class)
public interface UserService {
    @PostMapping("/byservice01/user/?token=333")
    void addUser(User user);

    @DeleteMapping("/byservice01/user/{id}?token=333")
    void deleteUserById(@PathVariable("id") Long id);

    @GetMapping("/byservice01/user/{id}?token=333")
    User findUserById(@PathVariable("id") Long id);

    @PutMapping("/byservice01/user/{id}?token=333")
    void updateUserById(User user,@PathVariable("id")Long id);

    @GetMapping("/byservice01/user/?token=333")
    Map findAllUser();
}
