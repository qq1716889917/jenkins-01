package com.wzt.controller;

import com.wzt.po.User;
import com.wzt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/addUser")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/user/findAllUser";
    }

    @RequestMapping("/deleteUserById/{id}")
    public String deleteUserById(@PathVariable("id") String id) {
        userService.deleteUserById(Long.parseLong(id));
        return "redirect:/user/findAllUser";
    }

    @RequestMapping("/findUserById/{id}")
    public String findUserById(Model model, @PathVariable("id") String id) {
        model.addAttribute("user", userService.findUserById(Long.parseLong(id)));
        return "user-edit";
    }

    @RequestMapping("/updateUserById/{id}")
    public String updateUserById(@PathVariable("id") String id, User user) {
        user.setId(Long.parseLong(id));
        userService.updateUserById(user,user.getId());
        return "redirect:/user/findAllUser";
    }

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model) {
        Map map = userService.findAllUser();
        model.addAttribute("userlist", map.get("list"));
        model.addAttribute("version",map.get("version"));
        return "user-list";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {

        return "user-add";
    }

}
