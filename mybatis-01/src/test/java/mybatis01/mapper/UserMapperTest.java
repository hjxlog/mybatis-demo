package mybatis01.mapper;

import mybatis01.domain.User;
import mybatis01.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    @Test
    public void selectUserList() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            // 执行sql
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.selectUserList();
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
    public void selectById() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            // 执行sql
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void insert() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            // 执行sql
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(4, "huang", "123456");
            boolean rlt = userMapper.insert(user);
            System.out.println(rlt);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void update() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            // 执行sql
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(4, "huang-update", "123456");
            boolean rlt = userMapper.update(user);
            System.out.println(rlt);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void delete() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean rlt = userMapper.delete(4);
        System.out.println(rlt);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update2() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("password","edit-password");
        map.put("id",3);
        boolean rlt = userMapper.update2(map);
        System.out.println(rlt);
        sqlSession.commit();
        sqlSession.close();
    }

}
