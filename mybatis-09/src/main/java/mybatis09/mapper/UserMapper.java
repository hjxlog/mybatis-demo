package mybatis09.mapper;

import mybatis09.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUserById(@Param("id") int id);

}
