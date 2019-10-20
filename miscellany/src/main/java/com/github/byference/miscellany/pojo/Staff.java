package com.github.byference.miscellany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Staff
 *
 * @author byference
 * @since 2019-10-19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Staff {

    /**
     * 职员编号
     */
    private String staffNo;

    /**
     * 职员名称
     */
    private String staffName;
}
