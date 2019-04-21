package com.github.byference.util;

import com.github.byference.entity.Student;
import com.github.byference.enums.Gender;

import java.util.ArrayList;
import java.util.List;

/**
 * @author byference
 * @since 2019/04/21
 */
public class StudentsUtil {


    public static List<Student> genStudents() {

        List<Student> students = new ArrayList<>();
        students.add(new Student("0001", "joy", 12, Gender.MALE));
        students.add(new Student("0002", "tom", 13, Gender.MALE));
        students.add(new Student("0003", "lucy", 14, Gender.FEMALE));
        students.add(new Student("0004", "lily", 16, Gender.FEMALE));
        students.add(new Student("0005", "windows", 16, Gender.MALE));
        students.add(new Student("0006", "mac", 15, Gender.MALE));
        students.add(new Student("0007", "linux", 22, Gender.MALE));
        students.add(new Student("0007", "linux", 22, Gender.MALE));
        return students;
    }

}
