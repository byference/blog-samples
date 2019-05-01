package com.github.byference.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author byference
 * @since 2019/05/01
 */
@Accessors(chain = true)
@Setter
@Getter
@ToString
public class Person {

    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;
}
