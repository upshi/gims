package com.yiheidaodi.gims.common;

import com.yiheidaodi.gims.model.Student;
import com.yiheidaodi.gims.model.TeachClass;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * gims com.yiheidaodi.gims.common
 * 描述：
 * 作者：王豫宁
 * 时间：2016-9-21 21:18.
 */

public class ExcelUtil {

    public static List<Student> extractStudent(InputStream inputStream) {

        List<Student> students = new ArrayList<>();

        try {
            //获取excel对象
            HSSFWorkbook xls = new HSSFWorkbook(inputStream);
            //获取excel文件中的第X个sheet
            HSSFSheet sheet = xls.getSheetAt(0);
            //获取总行数
            int rowNum = sheet.getLastRowNum();
            HSSFRow row = null;
            Student stu = null;
            TeachClass teachClass = null;

            //遍历行,封装User对象,调用方法插入数据库
            for (int i = 1; i <=rowNum; i++) {
                stu = new Student();
                teachClass = new TeachClass();
                row = sheet.getRow(i);

                stu.setStudentNo(row.getCell(0).getStringCellValue());
                stu.setName(row.getCell(1).getStringCellValue());
                stu.setTel(row.getCell(5).getStringCellValue());
                stu.setEmail(row.getCell(6).getStringCellValue());
                stu.setIdNo(row.getCell(7).getStringCellValue());

                teachClass.setGrade(row.getCell(2).getStringCellValue());
                teachClass.setMajor(row.getCell(3).getStringCellValue());
                teachClass.setClazz(row.getCell(4).getStringCellValue());

                stu.setTeachClass(teachClass);
                students.add(stu);
                // user.setDescription(row.getCell(10) == null ? "" : row.getCell(10).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
