package com.yiheidaodi.gims.service;

import com.yiheidaodi.gims.model.TeachClass;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 14:13.
 */

public interface ITeachClassService {
    List<TeachClass> gradeList(String collegeName);

    void add(TeachClass teachClass);

    List<TeachClass> majorList(String college, String grade);

    List<TeachClass> clazzList(String college, String grade, String major);
}
