package com.yiheidaodi.gims.controller;

import com.yiheidaodi.gims.model.User;
import com.yiheidaodi.gims.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * gims com.yiheidaodi.gims.controller
 * 描述：
 * 作者：王豫宁
 * 时间：2016-9-8 18:38.
 */

@Controller
@RequestMapping("/verify")
public class VerifyController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/userLogin")
    @ResponseBody
    public Map<String, Object> userLogin(User user, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User correctUser = userService.userLogin(user);
        if(correctUser == null) {
            map.put("correct", 0);
        } else {
            map.put("correct", 1);
            map.put("role", correctUser.getRole());
            session.setAttribute("user", user);
        }
        return map;
    }

}
