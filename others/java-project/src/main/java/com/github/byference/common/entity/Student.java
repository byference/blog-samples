package com.github.byference.common.entity;

import com.github.byference.common.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author byference
 * @since 2019/04/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    /**
     * 学生编号
     */
    private String studentNo;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生年龄
     */
    private int age;

    /**
     * 学生性别
     */
    private Gender gender;


}
