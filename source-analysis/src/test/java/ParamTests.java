import analysis.domain.User;
import analysis.mapper.UserMapper;
import com.sun.deploy.net.MessageHeader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParamTests {
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
    public void singleTest(){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void test2(){
        SqlSession sqlSession = factory.openSession();
        final List<Object> list = new ArrayList<Object>();
        ResultHandler handler = new ResultHandler() {
            public void handleResult(ResultContext resultContext) {
                if(resultContext.getResultCount() == 1){
                    resultContext.stop();
                }
                list.add(resultContext.getResultObject());
            }
        };
        sqlSession.select("analysis.mapper.UserMapper.selectAll",handler);
        System.out.println(list.size());
    }
}
