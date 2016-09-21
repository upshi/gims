package com.yiheidaodi.gims.repository;

import com.yiheidaodi.gims.model.Sheet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * gims com.yiheidaodi.gims.repository
 * 描述：
 * 作者：王豫宁
 * 时间：2016-9-20 13:21.
 */

public interface SheetRepository extends MongoRepository<Sheet, ObjectId> {

}
