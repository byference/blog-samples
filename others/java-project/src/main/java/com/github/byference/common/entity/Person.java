package com.github.byference.common.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author byference
 * @since 2019/05/01
 */
@Accessors(chain = true)
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
