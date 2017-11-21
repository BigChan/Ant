package com.ant.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ant.dao.ArticleDao;
import com.ant.dao.UserInfoDao;
import com.ant.entity.Article;
import com.ant.entity.UserInfo;
import com.ant.service.ArticleService;
import com.ant.util.JsonUtils;
import com.ant.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    public ArticleDao articleDao;

    @Autowired
    public UserInfoDao userInfoDao;

    @Override
    public String getMyArticles(String username) {
        Map<String, Object> map = new HashMap<>();
        List<Article> articles = articleDao.getMyArticles(username);
        map.put("code", 1);
        map.put("message", "文章列表获取成功");
        JSONArray array = new JSONArray();
        for (Article article : articles) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("id", article.getId());
            UserInfo userInfo = userInfoDao.getUserInfo(article.getUsername());
            jsonObject.put("username", userInfo.getPenname() == null ? article.getUsername() : userInfo.getPenname());
            jsonObject.put("title", article.getTitle());
            jsonObject.put("views", article.getViews());
            jsonObject.put("createdate", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(article.getCreateDate()));

            array.add(jsonObject);
        }
        map.put("articles", array);

        return JsonUtils.toJsonString(map);
    }

    @Override
    public String searchArticles(String key) {
        List<Article> articles = articleDao.searchArticles(key);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "文章搜索成功");
        map.put("count",articles.size());
        JSONArray array = new JSONArray();
        for (Article article : articles) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("id", article.getId());
            UserInfo userInfo = userInfoDao.getUserInfo(article.getUsername());
            jsonObject.put("username", userInfo.getPenname() == null ? article.getUsername() : userInfo.getPenname());
            jsonObject.put("title", article.getTitle());

            String content = article.getContent();
            if (content.length() > 50) {
                content = content.substring(0, 50) + "...";
            }

            jsonObject.put("content", content);
            jsonObject.put("views", article.getViews());
            jsonObject.put("createdate", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(article.getCreateDate()));

            array.add(jsonObject);
        }
        map.put("articles", array);

        return JsonUtils.toJsonString(map);
    }

    @Override
    public String getArticleById(int id) {
        Article article = articleDao.getArticleById(id);
        Map<String, Object> map = new HashMap<>();
        if (article != null) {
            map.put("code", 1);
            map.put("message", "文章获取成功");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", article.getId());
            UserInfo userInfo = userInfoDao.getUserInfo(article.getUsername());
            jsonObject.put("username", userInfo.getPenname() == null ? article.getUsername() : userInfo.getPenname());
            jsonObject.put("title", article.getTitle());
            jsonObject.put("content", article.getContent());
            jsonObject.put("views", article.getViews());
            jsonObject.put("createdate", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(article.getCreateDate()));

            map.put("article", jsonObject);
        } else {
            map.put("code", 0);
            map.put("message", "文章获取失败");
            map.put("article", null);
        }
        return JsonUtils.toJsonString(map);
    }

    @Override
    public String saveArticle(String username, String title, String content) {
        Map<String, Object> map = new HashMap<>();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {
            map.put("code", 0);
            map.put("message", "文章提交失败");
            return JsonUtils.toJsonString(map);
        }
        Article article = new Article();
        article.setUsername(username);
        article.setCreateDate(new Date());
        article.setTitle(title);
        article.setContent(content);
        article.setViews(1);
        articleDao.saveArticle(article);
        map.put("code", 1);
        map.put("message", "文章提交成功");
        map.put("id", article.getId());
        return JsonUtils.toJsonString(map);
    }

    @Override
    public String recommendArticles(Integer start) {
        List<Article> articles = articleDao.getRecommendArticles(start);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "文章列表获取成功");
        JSONArray array = new JSONArray();
        for (Article article : articles) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("id", article.getId());
            UserInfo userInfo = userInfoDao.getUserInfo(article.getUsername());
            jsonObject.put("username", userInfo.getPenname() == null ? article.getUsername() : userInfo.getPenname());
            jsonObject.put("title", article.getTitle());

            String content = article.getContent();
            if (content.length() > 200) {
                content = content.substring(0, 200) + "...";
            }

            jsonObject.put("content", content);
            jsonObject.put("views", article.getViews());
            jsonObject.put("createdate", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(article.getCreateDate()));

            array.add(jsonObject);
        }
        map.put("articles", array);

        return JsonUtils.toJsonString(map);
    }
}
