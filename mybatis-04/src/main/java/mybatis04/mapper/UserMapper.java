package mybatis04.mapper;


import mybatis04.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User selectById(Integer id);

    List<User> getUserByPages(Map<String,String> map);

    List<User> getUserList();
}
