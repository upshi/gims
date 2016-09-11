package com.yiheidaodi.gims.dao;

import com.yiheidaodi.gims.model.Sheet;

/**
 * gims com.yiheidaodi.gims.service
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 14:12.
 */

public interface ISheetDao {
    Sheet findByOwnerAndName(String college, String name);

    void add(Sheet sheet);
}
