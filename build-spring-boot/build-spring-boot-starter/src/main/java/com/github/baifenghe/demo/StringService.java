package com.github.baifenghe.demo;

import org.springframework.util.StringUtils;

/**
 * @author bfh
 * @since 2019/01/16
 */
public class StringService {

    /**
     * 将字符串转为大写
     */
    public String toUpperCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        } else {
            return str.toUpperCase();
        }
    }

}
