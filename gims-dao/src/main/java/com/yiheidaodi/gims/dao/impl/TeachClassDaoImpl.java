package com.yiheidaodi.gims.dao.impl;

import com.yiheidaodi.gims.dao.ITeachClassDao;
import com.yiheidaodi.gims.model.TeachClass;
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
 * 时间：2016-8-28 15:25.
 */

@Repository
public class TeachClassDaoImpl implements ITeachClassDao {

    @Autowired
    MongoOperations mongoOps;

    @Override
    public List<TeachClass> getAllGrades(String collegeName) {
        return mongoOps.find(new Query(where("college").is(collegeName).and("major").is("").and("clazz").is("")), TeachClass.class);
    }

    @Override
    public void add(TeachClass teachClass) {
        mongoOps.insert(teachClass);
    }

    @Override
    public List<TeachClass> getAllMajors(String college, String grade) {
        return mongoOps.find(new Query(where("college").is(college).and("grade").is(grade).and("clazz").is("")), TeachClass.class);
    }

    @Override
    public List<TeachClass> getAllClazzs(String college, String grade, String major) {
        return mongoOps.find(new Query(where("college").is(college).and("grade").is(grade).and("major").is(major)), TeachClass.class);
    }
}
