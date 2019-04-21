package com.github.byference.stream;

import com.github.byference.entity.Student;
import com.github.byference.util.StudentsUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * {@link java.util.stream.Stream} in action
 *
 * @author byference
 * @since 2019/04/21
 */
public class StreamTest {

    private static List<Student> students = StudentsUtil.genStudents();


    /**
     * 自定义去重: 根据学生编号去重
     */
    @Test
    public void distinctTest() {

        List<Student> collect = students.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getStudentNo))),
                ArrayList::new));
        collect.forEach(System.out::println);
    }


    /**
     * 根据学生编号分组，value为学生的姓名
     */
    @Test
    public void groupingTest() {

        Map<String, List<String>> collect = students.stream().collect(Collectors.groupingBy(
                Student::getStudentNo,
                Collectors.mapping(Student::getName, Collectors.toList())));
        collect.forEach((k, v) -> System.out.printf("studentNo: [%s], name: %s \n", k, v));
    }

}
