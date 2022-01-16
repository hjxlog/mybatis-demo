package mybatis08.mapper;

import mybatis08.domain.Blog;
import mybatis08.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogMapperTests {

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Map map = new HashMap<String,String>();
            map.put("title","mybatis学习笔记");
            List<Blog> blogList = blogMapper.queryBlogIF(map);
            for (Blog blog : blogList) {
                System.out.println(blog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryBlogChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Map map = new HashMap<String,String>();
            map.put("title","mybatis学习笔记");
            map.put("author","李四");
            List<Blog> blogList = blogMapper.queryBlogChoose(map);
            for (Blog blog : blogList) {
                System.out.println(blog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateBlogSet() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Map map = new HashMap<String,Object>();
            map.put("title","mybatis学习笔记-update");
            map.put("author","张三-update");
            map.put("id",1);
            int rlt = blogMapper.updateBlogSet(map);
            System.out.println("rlt====>"+rlt);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryBlogForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Map map = new HashMap<String,Object>();
            List<Integer> ids = new ArrayList<Integer>();
            ids.add(1);
            ids.add(2);
            map.put("ids",ids);
            List<Blog> blogList = blogMapper.queryBlogForeach(map);
            for (Blog blog : blogList) {
                System.out.println(blog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
