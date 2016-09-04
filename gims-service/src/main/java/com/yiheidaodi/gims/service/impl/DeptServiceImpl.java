package com.yiheidaodi.gims.service.impl;

import com.yiheidaodi.gims.dao.IDeptDao;
import com.yiheidaodi.gims.model.Dept;
import com.yiheidaodi.gims.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service.impl
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 15:06.
 */

@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDao deptDao;

    @Override
    public void add(Dept dept) {
        deptDao.add(dept);
    }

    @Override
    public List<Dept> collegeList() {
        return deptDao.getAllColleges();
    }

    @Override
    public List<Dept> deptList() {
        return deptDao.getAllDepts();
    }

    @Override
    public List<Dept> officeList(String deptName) {
        return deptDao.getOfficesByDeptName(deptName);
    }


}
