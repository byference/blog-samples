package com.github.byference.miscellany.mapstruct;

import com.github.byference.miscellany.pojo.Staff;
import com.github.byference.miscellany.pojo.Student;
import com.github.byference.miscellany.pojo.mapper.StudentMapper;
import com.github.byference.miscellany.util.PojoUtil;
import org.junit.Test;

import java.util.Objects;

/**
 * MapStructTest
 *
 * @author byference
 * @since 2019-10-19
 */
public class MapStructTest {

    @Test
    public void test1() {

        Staff staff = PojoUtil.getStaffInstance();
        Student student = StudentMapper.INSTANCE.toStudent(staff);
        assert Objects.equals(staff.getStaffName(), student.getStudentName());
    }
}
