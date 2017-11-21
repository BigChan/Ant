package com.ant.dao;

import com.ant.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */

public interface ArticleDao {

    Article getArticleById(@Param("id") int id);//通过文章中的id获取文章

    void saveArticle(Article article);

    List<Article> getMyArticles(@Param("username") String username);

    List<Article> getRecommendArticles(@Param("start")Integer start);

    List<Article> searchArticles(@Param("key") String key);
}
