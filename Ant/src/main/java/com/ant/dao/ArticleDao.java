package com.ant.dao;

import com.ant.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */

public interface ArticleDao {
    List<Article> getArticleByTitle(@Param("title") String title);//通过标题获取文章

    Article getArticleById(@Param("id") int id);//通过文章中的id获取文章

    void deleteArticleById(@Param("id") int id);

    void updateArticle(@Param("id")int id,@Param("user_id") int user_id,@Param("viewed") int viewed,
                       @Param("create_date") Date create_date,@Param("title") String title,@Param("content") String content);

    void saveArticle(@Param("user_id") int user_id,@Param("viewed") int viewed,
                     @Param("create_date") Date create_date,@Param("title") String title,@Param("content") String content);
}
