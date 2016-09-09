package com.yiheidaodi.gims.controller;

import com.yiheidaodi.gims.model.TeachClass;
import com.yiheidaodi.gims.model.User;
import com.yiheidaodi.gims.service.ITeachClassService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 时间：2016-8-28 15:30.
 */

@Controller
@RequestMapping("/teachClass")
public class TeachClassController {

    @Autowired
    private ITeachClassService teachClassService;

    @RequestMapping("/gradeList")
    @ResponseBody
    public Map<String, Object> gradeList(HttpSession session) {
        String college = getCollege(session);
        Map<String, Object> map = new HashMap<String, Object>();
        List<TeachClass> grades = teachClassService.gradeList(college);
        map.put("grades", grades);
        return map;
    }

    @RequestMapping("/addGrade")
    @ResponseBody
    public Map<String, Object> addGrade(String grade, HttpSession session) {
        String college = getCollege(session);
        Map<String, Object> map = new HashMap<String, Object>();
        TeachClass teachClass = new TeachClass(null, college , grade, "", "");
        teachClassService.add(teachClass);
        map.put("teachClass", teachClass);
        return map;
    }

    @RequestMapping("/majorList")
    @ResponseBody
    public Map<String, Object> majorList(String grade, HttpSession session) {
        String college = getCollege(session);
        Map<String, Object> map = new HashMap<String, Object>();
        List<TeachClass> majors = teachClassService.majorList(college, grade);
        map.put("majors", majors);
        return map;
    }

    @RequestMapping("/addMajor")
    @ResponseBody
    public Map<String, Object> addMajor(String grade, String major, HttpSession session) {
        String college = getCollege(session);
        Map<String, Object> map = new HashMap<String, Object>();
        TeachClass teachClass = new TeachClass(null, college , grade, major, "");
        teachClassService.add(teachClass);
        map.put("teachClass", teachClass);
        return map;
    }

    @RequestMapping("/clazzList")
    @ResponseBody
    public Map<String, Object> clazzList(String grade, String major, HttpSession session) {
        String college = getCollege(session);
        Map<String, Object> map = new HashMap<String, Object>();
        List<TeachClass> clazzs = teachClassService.clazzList(college, grade, major);
        map.put("clazzs", clazzs);
        return map;
    }

    @RequestMapping("/addClazz")
    @ResponseBody
    public Map<String, Object> addClazz(String grade, String major, String clazz, HttpSession session) {
        String college = getCollege(session);
        Map<String, Object> map = new HashMap<String, Object>();
        TeachClass teachClass = new TeachClass(null, college , grade, major, clazz);
        teachClassService.add(teachClass);
        map.put("teachClass", teachClass);
        return map;
    }

    private String getCollege(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user.getDept().getName();
    }


}
