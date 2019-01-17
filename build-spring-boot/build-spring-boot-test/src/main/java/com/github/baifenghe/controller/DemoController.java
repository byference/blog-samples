package com.github.baifenghe.controller;

import com.github.baifenghe.demo.IntegerService;
import com.github.baifenghe.demo.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bfh
 * @since 2019/01/17
 */
@RestController
public class DemoController {

    @Autowired
    private IntegerService integerService;

    @Autowired
    private StringService stringService;


    /**
     * 测试StringService
     */
    @PostMapping("testStringService")
    public String testStringService(String str) {

        return stringService.toUpperCase(str);
    }

    /**
     * 测试IntegerService
     */
    @PostMapping("testIntegerService")
    public int testIntegerService(int n1, int n2) {

        return integerService.max(n1, n2);
    }


}
