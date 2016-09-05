package com.yiheidaodi.gims.dao.impl;

import com.yiheidaodi.gims.dao.IDeptDao;
import com.yiheidaodi.gims.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;


/**
 * gims com.yiheidaodi.gims.dao.impl
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 15:23.
 */

@Repository
public class DeptDaoImpl implements IDeptDao {

    @Autowired
    MongoOperations mongoOps;

    @Override
    public void add(Dept dept) {
        mongoOps.insert(dept);
    }

    @Override
    public List<Dept> getAllColleges() {
        return mongoOps.find(new Query(where("isCollege").is(1).and("office").is("")), Dept.class);
    }

    @Override
    public List<Dept> getAllDepts() {
        return mongoOps.find(new Query(where("isCollege").is(0).and("office").is("")), Dept.class);
    }

    @Override
    public List<Dept> getOfficesByDeptName(String deptName) {
        return mongoOps.find(new Query(where("name").is(deptName)), Dept.class);
    }
}
