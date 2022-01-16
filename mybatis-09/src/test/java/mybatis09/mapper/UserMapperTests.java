package mybatis09.mapper;

import mybatis09.domain.User;
import mybatis09.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTests {

    @Test
    public void selectUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.selectUserById(1);
            System.out.println(user1);
            User user2 = userMapper.selectUserById(2);
            System.out.println(user2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void selectUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.selectUserById(1);
        System.out.println(user1);
        sqlSession.close();

        System.out.println("============");

        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.selectUserById(1);
        System.out.println(user2);
        sqlSession2.close();
    }

}
