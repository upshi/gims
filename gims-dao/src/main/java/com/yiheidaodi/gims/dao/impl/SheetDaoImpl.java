package com.yiheidaodi.gims.dao.impl;

import com.yiheidaodi.gims.dao.ISheetDao;
import com.yiheidaodi.gims.model.Sheet;
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
 * 时间：2016-8-28 15:24.
 */

@Repository
public class SheetDaoImpl implements ISheetDao {

    @Autowired
    MongoOperations mongoOps;

    @Override
    public Sheet findByOwnerAndName(String college, String name) {
        return mongoOps.findOne(new Query(where("owner").is(college).and("name").is(name)), Sheet.class);
    }

    @Override
    public void add(Sheet sheet) {
        mongoOps.insert(sheet);
    }

    @Override
    public List<Sheet> getSheetsByOwner(String owner) {
        return mongoOps.find(new Query(where("owner").is(owner)), Sheet.class);
    }

    @Override
    public Sheet getBySheetId(String sheetId) {
        return mongoOps.findOne(new Query(where("id").is(sheetId)), Sheet.class);
    }
}
