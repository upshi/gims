package com.yiheidaodi.gims.dao;

import com.yiheidaodi.gims.model.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * gims com.yiheidaodi.gims.service
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 14:14.
 */

public interface IElementDao {
    List<Element> findAllBySheetId(String sheetId);

    void addAll(ArrayList<Element> elements);
}
