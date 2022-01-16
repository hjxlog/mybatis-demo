package mybatis05.mapper;


import mybatis05.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from public.user")
    List<User> selectAll();

    @Select("select * from public.user where id = #{id}")
    User selectUserById(@Param("id") int theId);

    @Insert("insert into public.user (id,name,password) values (#{id},#{userName},#{password})")
    void insertUser(User user);

    @Update("update public.user set id=#{id},name=#{userName},password=#{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from public.user where id = #{uid}")
    int deleteUser(@Param("uid") int id);

}
