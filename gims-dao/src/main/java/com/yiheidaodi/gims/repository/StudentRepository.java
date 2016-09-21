package com.yiheidaodi.gims.repository;

import com.yiheidaodi.gims.model.Student;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.repository
 * 描述：
 * 作者：王豫宁
 * 时间：2016-9-20 13:21.
 */

public interface StudentRepository extends MongoRepository<Student, ObjectId> {

    Page<Student> findByTeachClassCollege(String college, Pageable pageable);

    List<Student> findByName(String name);
}
