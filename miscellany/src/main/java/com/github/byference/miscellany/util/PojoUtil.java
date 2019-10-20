package com.github.byference.miscellany.util;

import com.github.byference.miscellany.pojo.Staff;
import com.github.byference.miscellany.pojo.Student;

import java.util.Date;

/**
 * PojoUtil
 *
 * @author byference
 * @since 2019-10-19
 */
public class PojoUtil {

    private PojoUtil() {}


    public static Staff getStaffInstance() {
        Staff staff = new Staff();
        staff.setStaffName("joy");
        staff.setStaffNo("T0001");
        return staff;
    }

    public static Student getStudentInstance() {
        Student student = new Student();
        student.setStudentName("joy");
        student.setGender("male");
        student.setRegistryDate(new Date());
        return student;
    }

}
