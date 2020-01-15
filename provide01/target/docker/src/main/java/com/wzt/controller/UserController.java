package com.wzt.controller;

import com.wzt.po.User;
import com.wzt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {
    @Value("${version}")
    private String version;

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "add-success";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") String id) {
        userService.deleteUserById(Long.parseLong(id));
        return "delete-success";
    }

    @GetMapping("/{id}")
    public User findUserById( @PathVariable("id") String id) {

        return userService.findUserById(Long.parseLong(id));
    }

    @PutMapping("/{id}")
    public String updateUserById(@PathVariable("id") String id, @RequestBody User user) {
        user.setId(Long.parseLong(id));
        userService.updateUserById(user);
        return "update-success";
    }

    @GetMapping("/")
    public Map findAllUser() {
        Map map=new HashMap();
        List<User> list = userService.findAllUser();
        map.put("list",list);
        map.put("version",version);

        /*测试熔断设置睡眠*/
        /*int sleeptime = new Random().nextInt(1000);
        System.out.println("服务1,休息"+sleeptime);
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return map;
    }



}
