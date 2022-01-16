package mybatis02.mapper;

import mybatis02.domain.User;
import mybatis02.utils.MybatisUtils;
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
}
