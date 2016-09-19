package com.yiheidaodi.gims.service.impl;

import com.yiheidaodi.gims.dao.IElementDao;
import com.yiheidaodi.gims.model.Element;
import com.yiheidaodi.gims.service.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * gims com.yiheidaodi.gims.service.impl
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 15:07.
 */

@Service
public class ElementServiceImpl implements IElementService {

    @Autowired
    private IElementDao elementDao;

    @Override
    public List<Element> findAllBySheetId(String sheetId) {
        return elementDao.findAllBySheetId(sheetId);
    }

    @Override
    public void addAll(ArrayList<Element> elements) {
        elementDao.addAll(elements);
    }
}
