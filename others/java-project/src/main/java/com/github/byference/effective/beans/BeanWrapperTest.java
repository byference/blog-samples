package com.github.byference.effective.beans;

import com.github.byference.common.entity.Student;

/**
 * BeanWrapperTest
 *
 * @author byference
 * @since 2019-08-23
 */
public class BeanWrapperTest {


    public static void main(String[] args) {

        BeanWrapper wrapper = new BeanWrapper(Student.class);
        wrapper.setPropertyValue("studentNo", "00001");
        wrapper.setPropertyValue("name", "joy");
        Student student = wrapper.getWrappedInstance();

        System.out.println(student);
    }


}
