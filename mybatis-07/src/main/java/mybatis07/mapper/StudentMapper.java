package mybatis07.mapper;

import mybatis07.domain.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> selectStudentList();

    List<Student> selectStudentList2();

}
