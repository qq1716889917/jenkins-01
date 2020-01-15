package com.wzt.service;

import com.wzt.po.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public void updateUserById(User user, Long id) {

    }

    @Override
    public Map findAllUser() {
        Map map = new HashMap();
        map.put("list",new ArrayList<>());
        map.put("version","服务调用失败,userman03熔断了");
        return map;
    }
}
