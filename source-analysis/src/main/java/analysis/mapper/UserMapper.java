package analysis.mapper;


import analysis.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUserById(@Param("id") int id);

}
