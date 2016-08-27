package com.yiheidaodi.gims.controller;

import com.yiheidaodi.gims.model.Sheet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * gims com.yiheidaodi.gims.controller
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-25 09:17.
 */

@Controller
@RequestMapping("/")
public class AppController {

    @RequestMapping("/aa")
    public String index() {
        Sheet sheet = new Sheet();
        return "redirect:/index.jsp";
    }

}
