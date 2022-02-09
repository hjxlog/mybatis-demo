package analysis.mapper;


import analysis.domain.Blog;
import analysis.domain.User;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {

    Blog selectById(@Param("id") int id);

}
