package com.github.byference.miscellany.pojo;

import lombok.Data;

/**
 * Person
 *
 * @author byference
 * @since 2019-10-19
 */
@Data
public class Person {

    /**
     * 名称
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 职员编号
     */
    private String personNo;

    /**
     * 注册时间
     */
    private String registryDate;

}
