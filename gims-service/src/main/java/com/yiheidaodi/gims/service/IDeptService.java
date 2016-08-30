package com.yiheidaodi.gims.service;

import com.yiheidaodi.gims.model.Dept;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 14:12.
 */

public interface IDeptService {

    void add(Dept dept);

    List<Dept> collegeList();

}
