package com.github.byference.effective.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * CodeValueEnum
 *
 * @author byference
 * @since 2019-09-20
 */
@AllArgsConstructor
@Getter
public enum CodeValueEnum implements IntegerCodeValue {

    MONDAY(1, "周一"),
    TUESDAY(2, "周二"),
    WEDNESDAY(3, "周三"),
    THURSDAY(4, "周四"),
    FRIDAY(5, "周五"),
    SATURDAY(6, "周六"),
    SUNDAY(7, "周日");


    private int code;

    private String value;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getValue() {
        return value;
    }

}
