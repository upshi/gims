package com.yiheidaodi.gims.service.impl;

import com.yiheidaodi.gims.dao.ISheetDao;
import com.yiheidaodi.gims.model.Sheet;
import com.yiheidaodi.gims.service.ISheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service.impl
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 15:13.
 */

@Service
public class SheetServiceImpl implements ISheetService {

    @Autowired
    private ISheetDao sheetDao;

    @Override
    public Sheet findByOwnerAndName(String college, String name) {
        return sheetDao.findByOwnerAndName(college, name);
    }

    @Override
    public void add(Sheet sheet) {
        sheetDao.add(sheet);
    }

    @Override
    public List<Sheet> sheetList(String owner) {
        return sheetDao.getSheetsByOwner(owner);
    }

    @Override
    public Sheet getSheetById(String sheetId) {
        return sheetDao.getBySheetId(sheetId);
    }
}
