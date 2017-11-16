package com.ant.service.impl;

import com.ant.dao.ArticleDao;
import com.ant.entity.Article;
import com.ant.service.ArticleService;
import com.ant.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    public ArticleDao articleDao;

    @Override
    public List<Article> getArticleByTitle(String title) {
        //title = "%"+title+"%";
        List<Article> articleList = articleDao.getArticleByTitle("%"+title+"%");
        return articleList;
    }

    @Override
    public Article getArticleById(int id) {
        Article article = articleDao.getArticleById(id);
        return article;
    }

    @Override
    public boolean saveArticle(int user_id, int viewed, Date create_date, String title, String content) {
        if(TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) return false;
        articleDao.saveArticle(user_id,viewed,create_date,title,content);
        return true;
    }

    @Override
    public boolean deleteArticleById(int id) {
        Article article = articleDao.getArticleById(id);
        boolean result = false;
        if (article != null) {
            articleDao.deleteArticleById(id);
            result = true;
        }
        return result;
    }

    @Override
    public boolean updateArticle(int id, int user_id, int viewed, Date create_date, String title, String content) {
        boolean result = false;
        Article article = articleDao.getArticleById(id);
        if(article==null){
            return result;
        }else {
            articleDao.updateArticle(id,user_id,viewed,create_date,title,content);
            result = true;
        }
        return result;
    }
}
