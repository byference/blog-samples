package com.github.byference.miscellany.controller;

import com.github.byference.miscellany.pojo.Person;
import com.github.byference.miscellany.pojo.Staff;
import com.github.byference.miscellany.pojo.Student;
import com.github.byference.miscellany.pojo.mapper.PersonMapper;
import com.github.byference.miscellany.util.PojoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MapStructController
 *
 * @author byference
 * @since 2019-10-19
 */
@RestController
public class MapStructController {

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("index")
    public Person index() {

        Staff staff = PojoUtil.getStaffInstance();
        Student student = PojoUtil.getStudentInstance();
        return personMapper.toPerson(student, staff);
    }

    @RequestMapping("update")
    public Person update() {

        Person person1 = new Person();
        person1.setName("update");
        person1.setPersonNo("T001");

        Person personVo = new Person();
        personMapper.update(person1, personVo);

        return personVo;
    }

}
