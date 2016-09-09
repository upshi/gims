package com.yiheidaodi.gims.dao;

import com.yiheidaodi.gims.model.TeachClass;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 14:13.
 */

public interface ITeachClassDao {
    List<TeachClass> getAllGrades(String collegeName);

    void add(TeachClass teachClass);

    List<TeachClass> getAllMajors(String college, String grade);

    List<TeachClass> getAllClazzs(String college, String grade, String major);
}
