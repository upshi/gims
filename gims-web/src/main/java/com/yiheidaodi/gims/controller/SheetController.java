package com.yiheidaodi.gims.controller;

import com.yiheidaodi.gims.model.Sheet;
import com.yiheidaodi.gims.model.User;
import com.yiheidaodi.gims.service.ISheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * gims com.yiheidaodi.gims.controller
 * 描述：
 * 作者：王豫宁
 * 时间：2016-8-28 15:30.
 */

@Controller
@RequestMapping("/sheet")
public class SheetController {

    @Autowired
    private ISheetService sheetService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/checkName")
    @ResponseBody
    public Map<String, Object> checkName(String name, HttpSession session) {
        String college = getCollege(session);
        Map<String, Object> map = new HashMap<String, Object>();
        Sheet sheet = sheetService.findByOwnerAndName(college, name);
        if(sheet != null) {
            map.put("exist", 1);
        } else {
            map.put("exist", 0);
        }
        return map;
    }

    @RequestMapping("/create")
    @ResponseBody
    public Map<String, Object> create(Sheet sheet, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = (User) session.getAttribute("user");

        sheet.setCreaterId(user.getId());
        sheet.setOwner(user.getDept().getName());
        sheet.setStatus(Sheet.STATUS_CREATING);
        sheet.setCreateTime(sdf.format(new Date()));

        sheetService.add(sheet);
        Sheet newSheet = sheetService.findByOwnerAndName(sheet.getOwner(), sheet.getName());
        map.put("newSheet", newSheet);

        return map;
    }



    private String getCollege(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user.getDept().getName();
    }
}
