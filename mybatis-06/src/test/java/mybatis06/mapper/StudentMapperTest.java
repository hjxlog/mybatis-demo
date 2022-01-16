package mybatis06.mapper;

import mybatis06.domain.Student;
import mybatis06.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {

    @Test
    public void selectStudentList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.selectStudentList();
            for (Student student : studentList) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectStudentList2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.selectStudentList2();
            for (Student student : studentList) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
