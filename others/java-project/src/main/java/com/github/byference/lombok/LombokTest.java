package com.github.byference.lombok;

import com.github.byference.entity.Person;
import org.junit.Test;

/**
 * LombokTest
 *
 * @author byference
 * @since 2019/05/01
 */
public class LombokTest {


    @Test
    public void accessorsTest() {

        Person person = new Person();
        person.setId(100).setName("jack");
        System.out.println(person);
    }

}
