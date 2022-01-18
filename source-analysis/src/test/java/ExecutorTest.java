import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ExecutorTest {

    private String url = "jdbc:postgresql://127.0.0.1:5432/postgres?useSSL=false";
    private String username = "postgres";
    private String password = "123456";

    private Configuration configuration;
    private Connection connection;
    private JdbcTransaction jdbcTransaction;

    @Before
    public void init () throws IOException, SQLException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = factoryBuilder.build(inputStream);
        configuration = factory.getConfiguration(); // 加载配置
        connection = DriverManager.getConnection(url,username,password);
        jdbcTransaction = new JdbcTransaction(connection);
    }

    @Test
    public void simpleTest() throws SQLException {
        SimpleExecutor simpleExecutor = new SimpleExecutor(configuration,jdbcTransaction);
        MappedStatement ms = configuration.getMappedStatement("analysis.mapper.UserMapper.selectUserById");
        List<Object> list = simpleExecutor.doQuery(ms, 1, RowBounds.DEFAULT,
                SimpleExecutor.NO_RESULT_HANDLER, ms.getBoundSql(1));
        for (Object o : list) {
            System.out.println(o);
        }

    }

}
