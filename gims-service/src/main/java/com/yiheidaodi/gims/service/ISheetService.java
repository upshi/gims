package com.yiheidaodi.gims.service;

import com.yiheidaodi.gims.model.Sheet;

import java.util.List;

/**
 * gims com.yiheidaodi.gims.service
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 14:12.
 */

public interface ISheetService {
    Sheet findByOwnerAndName(String college, String name);

    void add(Sheet sheet);

    List<Sheet> sheetList(String owner);

    Sheet getSheetById(String sheetId);
}
