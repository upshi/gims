package com.yiheidaodi.gims.service;

import com.yiheidaodi.gims.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * gims com.yiheidaodi.gims.service
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 14:12.
 */

public interface IStudentService {
    Page<Student> studentList(String college, Pageable pageable);
}
