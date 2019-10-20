package com.github.byference.miscellany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Student
 *
 * @author byference
 * @since 2019-10-19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    /**
     * 性别
     */
    private String gender;

    /**
     * 学生名称
     */
    private String studentName;

    /**
     * 注册时间
     */
    private Date registryDate;
}
