package mybatis02.mapper;

import mybatis02.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectUserList();

    User selectById(Integer id);

    boolean insert(User user);

    boolean update(User user);

    boolean update2(Map map);

    boolean delete(int id);
}
