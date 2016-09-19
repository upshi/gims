package com.yiheidaodi.gims.dao.impl;

import com.yiheidaodi.gims.dao.IElementDao;
import com.yiheidaodi.gims.model.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * gims com.yiheidaodi.gims.dao.impl
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 15:23.
 */

@Repository
public class ElementDaoImpl implements IElementDao {

    @Autowired
    MongoOperations mongoOps;

    @Override
    public List<Element> findAllBySheetId(String sheetId) {
        return mongoOps.find(new Query(where("sheetId").is(sheetId)), Element.class);
    }

    @Override
    public void addAll(ArrayList<Element> elements) {
        mongoOps.insertAll(elements);
    }
}
