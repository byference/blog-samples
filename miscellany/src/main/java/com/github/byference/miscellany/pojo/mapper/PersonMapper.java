package com.github.byference.miscellany.pojo.mapper;

import com.github.byference.miscellany.pojo.Person;
import com.github.byference.miscellany.pojo.Staff;
import com.github.byference.miscellany.pojo.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * PersonMapper
 *
 * @author byference
 * @since 2019-10-19
 */
@Mapper(componentModel = "spring", uses = DateMapper.class)
public interface PersonMapper {

    @Mapping(source = "student.studentName", target = "name")
    @Mapping(source = "staff.staffNo", target = "personNo")
//    @Mapping(target = "registryDate", dateFormat = "dd.MM.yyyy")
    @Mapping(target = "gender", ignore = true)
    Person toPerson(Student student, Staff staff);


    void update(Person person1, @MappingTarget Person person2);

}
