package com.yiheidaodi.gims.controller;

import com.yiheidaodi.gims.model.Dept;
import com.yiheidaodi.gims.service.IDeptService;
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
 * 时间：2016-8-29 19:34.
 */

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @RequestMapping("/collegeList")
    @ResponseBody
    public Map<String, Object> collegeList() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Dept> colleges = deptService.collegeList();
        map.put("colleges", colleges);
        return map;
    }

    @RequestMapping("/addCollege")
    @ResponseBody
    public Map<String, Object> addCollege(String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        Dept college = new Dept(null, name, "", 1);
        deptService.add(college);
        map.put("college", college);
        return map;
    }



}
