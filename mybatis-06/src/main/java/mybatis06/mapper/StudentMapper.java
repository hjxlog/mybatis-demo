package mybatis06.mapper;

import mybatis06.domain.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> selectStudentList();

    List<Student> selectStudentList2();

}
