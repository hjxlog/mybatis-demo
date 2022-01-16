package mybatis07.mapper;

import mybatis07.domain.Student;
import mybatis07.domain.Teacher;
import mybatis07.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTests {

    @Test
    public void selectStudentList2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teacherList = teacherMapper.selectTeachers();
            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getTeachers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teacherList = teacherMapper.getTeachers();
            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getTeachers2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teacherList = teacherMapper.getTeachers2();
            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


}
