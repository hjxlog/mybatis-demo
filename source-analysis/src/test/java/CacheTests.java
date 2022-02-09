import analysis.domain.Blog;
import analysis.domain.User;
import analysis.mapper.BlogMapper;
import analysis.mapper.UserMapper;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;
import sun.nio.cs.US_ASCII;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CacheTests {

    private String url = "jdbc:postgresql://127.0.0.1:5432/postgres?useSSL=false";
    private String username = "postgres";
    private String password = "123456";

    private Configuration configuration;
    private Connection connection;
    private JdbcTransaction jdbcTransaction;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException, SQLException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        factory = factoryBuilder.build(inputStream);
        configuration = factory.getConfiguration(); // 加载配置
        connection = DriverManager.getConnection(url, username, password);
        jdbcTransaction = new JdbcTransaction(connection);
    }

    @Test
    public void cacheTest1() {
        Cache cache = configuration.getCache("analysis.mapper.UserMapper");
        User user = new User();
        user.setUserName("黄");
        cache.putObject("huang", user);
        cache.getObject("huang");
    }

    /**
     * 测试二级缓存
     * <p>
     * 命中条件：
     * 1. 必须提交
     */
    @Test
    public void test2() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        sqlSession.commit(); // 提交之后才能命中二级缓存

        SqlSession sqlSession1 = factory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.selectUserById(1);

        System.out.println(user == user1);
    }

    @Test
    public void test3() {
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);

        BlogMapper mapper1 = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper1.selectById(1);
        System.out.println(blog);

    }

    @Test
    public void test4() {
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        // 上面查询结果只存到了暂存区
        sqlSession.commit(); // commit之后，才提交到缓存区

        SqlSession sqlSession1 = factory.openSession(true);
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper.selectUserById(1);
        System.out.println(user1);

    }
}
