package com.github.byference.lombok;

import com.github.byference.common.entity.Person;
import lombok.val;
import org.junit.Test;

import java.util.ArrayList;

/**
 * LombokTest
 *
 * @author byference
 * @since 2019/05/01
 */
public class LombokTest {


    @Test
    public void valVariableTest() {

        val person = new Person();
        person.setId(100).setName("jack");
        // person = null;
        // Cannot assign a value to final variable 'person'

        val list = new ArrayList<Person>();
        list.add(person);
        System.out.println(list);
    }


    @Test
    public void accessorsTest() {

        Person person = new Person();
        person.setId(100).setName("jack");
        System.out.println(person);
    }

}
