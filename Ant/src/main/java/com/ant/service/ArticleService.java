package com.ant.service;

import com.ant.entity.Article;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */

public interface ArticleService {
    List<Article> getArticleByTitle(String title);
    Article getArticleById(int id);
    boolean saveArticle(int user_id,int viewed,Date create_date,String title, String content);
    boolean deleteArticleById(int id);
    boolean updateArticle(int id,int user_id,int viewed,Date create_date,String title,String content);
}
