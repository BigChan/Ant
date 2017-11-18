package com.ant.web;

import com.ant.entity.Article;
import com.ant.service.ArticleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */
@Controller
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/getArticleByTitle")
    @ResponseBody
    public String getArticleByTitle(@RequestParam("title") String title) {
        List<Article> articleList = articleService.getArticleByTitle(title);
        String summary = null;
        Map map = new HashMap();
        for (Article a:articleList) {
            if(a.getContent().length()<50)
                summary = a.getContent().substring(0, a.getContent().length());
            else
                summary = a.getContent().substring(0, 50);
            a.setSummary(summary);
            map.put("id",a.getId());
            map.put("userId",a.getUserId());
            map.put("viewed",a.getViewed());
            map.put("createDate",a.getCreateDate());
            map.put("title",a.getTitle());
            map.put("content",a.getContent());
            map.put("summary",a.getSummary());
        }

         return ;
    }

    @RequestMapping("/getArticleById")
    @ResponseBody
    public String getArticleById(@RequestParam("id") int id) {
        Article article = articleService.getArticleById(id);
        return article;
    }

    @RequestMapping("/saveArticle")
    @ResponseBody
    public String saveArticle(@RequestParam("user_id") int user_id, @RequestParam("viewed") int viewed,
                              @RequestParam("create_date") Date create_date, @RequestParam("title") String title, @RequestParam("content") String content) {
        boolean isTrue = articleService.saveArticle(user_id,viewed,create_date,title,content);
        String returnString = "插入失败";
        if(isTrue){returnString = "插入成功";}
        return returnString;
    }

    @RequestMapping("/deleteArticleById")
    @ResponseBody
    public String deleteArticleById(@RequestParam("id") int id){
        boolean isTrue = articleService.deleteArticleById(id);
        String returnString = "删除失败";
        if(isTrue){returnString = "删除成功";}
        return returnString;
    }

    @RequestMapping("/updateArticle")
    @ResponseBody
    public String updateArticle(@RequestParam("id") int id,@RequestParam("user_id") int user_id,@RequestParam("viewed") int viewed,
                                @RequestParam("create_date") Date create_date, @RequestParam("title") String title, @RequestParam("content") String content){
        boolean isTrue = articleService.updateArticle(id,user_id,viewed,create_date,title,content);
        String returnString = "更新失败";
        if(isTrue){
            returnString = "更新成功";
        }
        return returnString;
    }
}
