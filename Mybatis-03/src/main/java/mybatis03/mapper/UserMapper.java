package mybatis03.mapper;


import mybatis03.domain.User;

public interface UserMapper {
    User selectById(Integer id);
}
