package mybatis05.mapper;

import mybatis05.domain.User;
import mybatis05.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void selectUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.selectAll();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void selectUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void insertUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(100,"hello-test","123");
            userMapper.insertUser(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(100,"hello-test-update","123");
            int i = userMapper.updateUser(user);
            System.out.println(i);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int i = userMapper.deleteUser(100);
            System.out.println(i);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }


}
