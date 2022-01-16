package mybatis03.mapper;


import mybatis03.domain.User;
import mybatis03.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void selectUserList() {
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
}
