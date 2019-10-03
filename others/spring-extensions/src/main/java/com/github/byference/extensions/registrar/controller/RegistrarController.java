package com.github.byference.extensions.registrar.controller;

import com.github.byference.extensions.registrar.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RegistrarController
 *
 * @author byference
 * @since 2019-10-03
 */
public class RegistrarController {

    @Autowired
    private TestMapper testMapper;

    /**
     * call {@link TestMapper#name}
     */
    @RequestMapping("name")
    public String name() {
        return testMapper.name();
    }


    /**
     * call {@link TestMapper#echo}
     */
    @RequestMapping("echo")
    public String echo() {
        return testMapper.echo();
    }

}
