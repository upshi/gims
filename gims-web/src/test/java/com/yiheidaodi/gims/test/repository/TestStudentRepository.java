package com.yiheidaodi.gims.test.repository;

import com.yiheidaodi.gims.model.Student;
import com.yiheidaodi.gims.model.TeachClass;
import com.yiheidaodi.gims.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * gims com.yiheidaodi.gims.test.dao
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-29 18:57.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mongo.xml" })
public class TestStudentRepository {

    @Autowired
    StudentRepository studentRepository;

    // @Test
    public void testInsert() {
        TeachClass teachClass = new TeachClass("57d2ae5286835d998087e7eb", "计算机与通信学院", "2016", "软件工程", "2班");
        Student student = new Student(null, "21651192", "1313", "ranran", teachClass, "1313123", "d2d2@qq.com", "362105311006151103");
        Student insert = studentRepository.insert(student);
        System.out.println("-----------------------------------------");
        System.out.println(insert);
        System.out.println("-----------------------------------------");
    }

    @Test
    public void testFindByTeachClass() {
        // TeachClass teachClass = new TeachClass("cadwae5286835d9980874rta", "电信学院", "2016", "软件工程", "1班");
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "teachClass.grade"));
        Pageable pageable = new PageRequest(0,1,sort);
        Page<Student> list = studentRepository.findByTeachClassCollege("计算机与通信学院", pageable);
        // List<Student> upshi = studentRepository.findByName("upshi");
        System.out.println("-----------------------------------------");
        System.out.println(list);
        System.out.println("-----------------------------------------");
    }

    @Test
    public void empty() {
        System.out.println("-------------- TEST ---------------");
    }



}
