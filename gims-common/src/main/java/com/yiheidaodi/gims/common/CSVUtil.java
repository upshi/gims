package com.yiheidaodi.gims.common;

import com.yiheidaodi.gims.dto.ListAndMsg;
import com.yiheidaodi.gims.model.Student;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * gims com.yiheidaodi.gims.common
 * 描述：
 * 作者：王豫宁
 * 时间：2016-9-21 09:36.
 */

public class CSVUtil {

    public ListAndMsg<Student> extractStudent(InputStream in) {
        List<Student> students = new ArrayList<>();
        List<ListAndMsg.Pair> msgs = new ArrayList<ListAndMsg.Pair>();

        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.EXCEL.parse(new InputStreamReader(in));
        } catch (IOException e) {
            e.printStackTrace();
            msgs.add(new ListAndMsg.Pair("EXCEPTION", "IOException"));
        }

        for (CSVRecord record : records) {
            String lastName = record.get("Last Name");
            String firstName = record.get("First Name");
        }

        ListAndMsg<Student> lam = new ListAndMsg<>(students, msgs);
        return lam;
    }

}
