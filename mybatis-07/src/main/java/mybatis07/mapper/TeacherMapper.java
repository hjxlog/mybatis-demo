package mybatis07.mapper;

import mybatis07.domain.Teacher;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> selectTeachers();

    List<Teacher> getTeachers();

    List<Teacher> getTeachers2();

}
