package com.ant.service;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */

public interface ArticleService {

    String getArticleById(int id);

    String getMyArticles(String username);

    String searchArticles(String key);

    String saveArticle(String username, String title, String content);

    String recommendArticles(Integer start);
}
