package com.github.byference.common.vo;

import com.github.byference.common.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author byference
 * @since 2019/05/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentVo {

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
