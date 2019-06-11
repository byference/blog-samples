package com.github.byference.effective.normal;

import org.junit.Test;

import java.util.Date;

/**
 * @author byference
 * @since 2019/06/11
 */
public class StringTest {


    @Test
    public void stringFormat() {

        // 将1格式化为0001
        System.out.println(String.format("%04d", 1));

        // 将10000格式化为10,000
        System.out.println(String.format("%,d", 10000));
        System.out.println(String.format("%+d", 10000));
        System.out.println(String.format("%(,d", -10000));


        Date now = new Date();
        System.out.printf("%s %s", String.format("%tF", now), String.format("%tT", now));
    }


}
