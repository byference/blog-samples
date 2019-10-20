package com.github.byference.miscellany.pojo.mapper;

import com.github.byference.miscellany.pojo.Staff;
import com.github.byference.miscellany.pojo.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * StudentMapper
 *
 * @author byference
 * @since 2019-10-19
 */
@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "staffName", target = "studentName")
    Student toStudent(Staff staff);
}
