package com.yiheidaodi.gims.controller;

import com.yiheidaodi.gims.model.Student;
import com.yiheidaodi.gims.model.User;
import com.yiheidaodi.gims.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * gims com.yiheidaodi.gims.controller
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 15:27.
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/studentList")
    @ResponseBody
    public Map<String, Object> studentList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size, HttpSession session) {
        String college = getCollege(session);
        Map<String, Object> map = new HashMap<String, Object>();
        Pageable pageable = new PageRequest(page-1, size);
        Page<Student> result = studentService.studentList(college, pageable);
        map.put("students", result.getContent());
        map.put("totals", result.getTotalElements());
        return map;
    }

    @RequestMapping(value = "/upload")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes;
        if (!file.isEmpty()) {
            bytes = file.getBytes();
            //store file in storage
        }
    }

    private String getCollege(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user.getDept().getName();
    }

}
