package mybatis08.mapper;

import mybatis08.domain.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {


    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogChoose(Map map);

    int updateBlogSet(Map map);

    List<Blog> queryBlogForeach(Map map);
}
