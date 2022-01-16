package mybatis04.mapper;

import mybatis04.domain.User;
import mybatis04.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void selectUserList() {
        logger.info("===info===");
        logger.debug("===debug===");
        logger.error("===error===");
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
    public void getUserByPages() {
        // 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            // 执行sql
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map map = new HashMap<String,String>();
            map.put("startIndex",3);
            map.put("pageSize",3);
            List<User> list = userMapper.getUserByPages(map);
            for (User user : list) {
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
    public void getUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            RowBounds rowBounds = new RowBounds(1, 2);
            List<User> userList = sqlSession.selectList("mybatis04.mybatis06.mapper.UserMapper.getUserList",null,rowBounds);
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
