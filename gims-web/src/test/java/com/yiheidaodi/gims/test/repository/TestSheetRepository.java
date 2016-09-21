package com.yiheidaodi.gims.test.repository;

import com.yiheidaodi.gims.model.Sheet;
import com.yiheidaodi.gims.repository.SheetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * gims com.yiheidaodi.gims.test.dao
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-29 18:57.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mongo.xml" })
public class TestSheetRepository {

    @Autowired
    SheetRepository sheetRepository;

    // @Test
    public void testInstance() {
        System.out.println("-----------------------------------------");
        System.out.println(sheetRepository);
    }

    // @Test
    public void testInsert() {
        Sheet sheet = new Sheet(null, "test", "test", "test", "test", "test", 0);
        Sheet insert = sheetRepository.insert(sheet);
        System.out.println("-----------------------------------------");
        System.out.println(insert);
        System.out.println("-----------------------------------------");
    }

    // @Test
    public void testSave() {
        Sheet sheet = new Sheet("57e0ca864ddda3487ca30a05", "test1", "test1", "test1", "test1", "test1", 0);
        Sheet save = sheetRepository.save(sheet);
        System.out.println("-----------------------------------------");
        System.out.println(save);
        System.out.println("-----------------------------------------");
    }

    @Test
    public void empty() {
        System.out.println("-------------- TEST ---------------");
    }



}
