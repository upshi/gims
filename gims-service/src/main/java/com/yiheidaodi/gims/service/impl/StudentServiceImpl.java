package com.yiheidaodi.gims.service.impl;

import com.yiheidaodi.gims.model.Student;
import com.yiheidaodi.gims.repository.StudentRepository;
import com.yiheidaodi.gims.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service.impl
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 15:13.
 */

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Page<Student> studentList(String college, Pageable pageable) {
        return studentRepository.findByTeachClassCollege(college, pageable);
    }
}
