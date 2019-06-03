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
    public void beanCopierTest2() {

        Student student = new Student("117", "tom", 26, Gender.MALE);
        StudentVo studentVo = new StudentVo();

        final BeanCopier copier = getBeanCopier(Student.class, StudentVo.class, false);
        copier.copy(student, studentVo, null);
        System.out.println("studentVo: " + studentVo);
    }


    @Test
    public void beanCopierTest1() {

        Student student = new Student("007", "joy", 16, Gender.MALE);
        StudentVo studentVo = new StudentVo();

        final BeanCopier copier = BeanCopier.create(Student.class, StudentVo.class, false);
        copier.copy(student, studentVo, null);
        System.out.println("studentVo: " + studentVo);
    }


    /**
     * 动态生成 {@link BeanCopier}
     * @param source 源对象class
     * @param target 目标对象class
     * @param useConverter 是否使用转换器
     * @return {@link BeanCopier}
     */
    private static BeanCopier getBeanCopier(Class source, Class target, boolean useConverter) {
        return BeanCopier.create(source, target, useConverter);
    }

}
