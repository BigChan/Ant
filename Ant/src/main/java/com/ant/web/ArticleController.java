package com.ant.web;

import com.ant.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */
@Controller
@RequestMapping(produces = "application/json;charset=UTF-8")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/searchArticles")
    @ResponseBody
    public String searchArticles(@RequestParam("key") String key) {
        return articleService.searchArticles(key);
    }

    @RequestMapping("/getArticleById")
    @ResponseBody
    public String getArticleById(@RequestParam("id") int id) {
        return articleService.getArticleById(id);
    }

    @RequestMapping("/getMyArticles")
    @ResponseBody
    public String getMyArticles(@RequestParam("username") String username) {
        return articleService.getMyArticles(username);
    }

    @RequestMapping("/saveArticle")
    @ResponseBody
    public String saveArticle(@RequestParam("username") String username, @RequestParam("title") String title, @RequestParam("content") String content) {
        return articleService.saveArticle(username, title, content);
    }

    @RequestMapping("/recommendArticles")
    @ResponseBody
    public String recommendArticles(@RequestParam("start")Integer start) {
        return articleService.recommendArticles(start);
    }

}
