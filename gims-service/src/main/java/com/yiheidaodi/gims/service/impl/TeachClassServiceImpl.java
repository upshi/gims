package com.yiheidaodi.gims.service.impl;

import com.yiheidaodi.gims.dao.ITeachClassDao;
import com.yiheidaodi.gims.model.TeachClass;
import com.yiheidaodi.gims.service.ITeachClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service.impl
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 15:14.
 */

@Service
public class TeachClassServiceImpl implements ITeachClassService {

    @Autowired
    private ITeachClassDao teachClassDao;

    @Override
    public List<TeachClass> gradeList(String collegeName) {
        return teachClassDao.getAllGrades(collegeName);
    }

    @Override
    public void add(TeachClass teachClass) {
        teachClassDao.add(teachClass);
    }

    @Override
    public List<TeachClass> majorList(String college, String grade) {
        return teachClassDao.getAllMajors(college, grade);
    }

    @Override
    public List<TeachClass> clazzList(String college, String grade, String major) {
        return teachClassDao.getAllClazzs(college, grade, major);
    }
}
