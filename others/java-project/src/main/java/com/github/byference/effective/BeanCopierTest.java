package com.github.byference.effective;

import com.github.byference.common.entity.Student;
import com.github.byference.common.enums.Gender;
import com.github.byference.common.vo.StudentVo;
import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @author byference
 * @since 2019/05/18
 */
public class BeanCopierTest {


    @Test
    public void beanCopierTest() {

        Student student = new Student("007", "joy", 16, Gender.MALE);


        final BeanCopier copier = BeanCopier.create(Student.class, StudentVo.class, false);
        StudentVo studentVo = new StudentVo();
        copier.copy(student, studentVo, null);
        System.out.println("studentVo: " + studentVo);


    }
}
