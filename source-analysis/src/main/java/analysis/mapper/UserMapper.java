package analysis.mapper;


import analysis.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User selectUserById(@Param("id") int id);

    List<User> selectAll();

}
