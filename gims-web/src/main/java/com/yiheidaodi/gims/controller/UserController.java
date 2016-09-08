package com.yiheidaodi.gims.controller;

import com.yiheidaodi.gims.model.User;
import com.yiheidaodi.gims.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * gims com.yiheidaodi.gims.controller
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 09:16.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/userList")
    @ResponseBody
    public Map<String, Object> userList() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> users = userService.userList();
        map.put("users", users);
        return map;
    }

    @RequestMapping("/checkUserName")
    @ResponseBody
    public Map<String, Object> checkUserName(String userName) {
        Map<String, Object> map = new HashMap<String, Object>();
        int exist = userService.checkUserName(userName);
        map.put("exist", exist);
        return map;
    }

}
