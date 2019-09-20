package com.github.byference.effective.enumeration;

import org.junit.Test;

/**
 * CodeValueEnumTest
 *
 * @author byference
 * @since 2019-09-20
 */
public class CodeValueEnumTest {

    @Test
    public void testGetCodeByValue() {

        printEnum(CodeValueEnum.FRIDAY);
        printEnum(CodeValueEnum.SATURDAY);
    }


    private static void printEnum(IntegerCodeValue integerCodeValue) {

        System.out.println(integerCodeValue.getCode());
        System.out.println(integerCodeValue.getValue());
    }

}
