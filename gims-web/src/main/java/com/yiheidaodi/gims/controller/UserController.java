package com.yiheidaodi.gims.controller;

import com.yiheidaodi.gims.model.Dept;
import com.yiheidaodi.gims.model.User;
import com.yiheidaodi.gims.service.IDeptService;
import com.yiheidaodi.gims.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private IDeptService deptService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    @RequestMapping("/addUser")
    @ResponseBody
    public Map<String, Object> addUser(User user, String deptName, String office) {
        Map<String, Object> map = new HashMap<String, Object>();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Dept d = deptService.findByNameAndOffice(deptName, office);
        user.setDept(d);
        userService.add(user);
        map.put("user", user);
        return map;
    }

    @RequestMapping("/checkPassword")
    @ResponseBody
    public Map<String, Object> checkPassword(String password, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = (User) session.getAttribute("user");
        boolean correct = passwordEncoder.matches(password, user.getPassword());
        map.put("correct", correct);
        return map;
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public Map<String, Object> updatePassword(String oldPassword, String newPassword, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = (User) session.getAttribute("user");
        boolean correct = passwordEncoder.matches(oldPassword, user.getPassword());
        if(correct) {
            // userService.updatePassword();
            map.put("result", "success");
        }
        return map;
    }

}
