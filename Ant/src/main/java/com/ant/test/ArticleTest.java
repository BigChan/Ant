package com.ant.test;

import com.ant.entity.Article;
import com.ant.service.ArticleService;
import com.ant.web.ArticleController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */

public class ArticleTest extends BaseTest {

    @Autowired
    private ArticleService articleService;

    private ArticleController articleController;

    @Test
    public void testGetByTitle() throws Exception {
        ArticleController articleController = getArticleController();
        List<Article> articleList = articleController.getArticleByTitle("构建之法");
        if(articleList.size()==0){
            System.out.println("找不到数据");
        }else {
            for (Article article : articleList
                    ) {
                System.out.println(article.getCreateDate() +"\t"+article.getTitle() + "\t" + article.getContent());
            }
        }
    }

    @Test
    public void testGetById() throws Exception {
        ArticleController articleController = getArticleController();
        Article article = articleController.getArticleById(3);
        if(article==null){
            System.out.println("找不到数据");
        }else {
            System.out.println(article.getUserId() +"\t"+article.getTitle() + "\t" + article.getContent());
        }
    }

    @Test
    public void testSaveArticle() throws Exception{
        ArticleController articleController = getArticleController();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date create_date = sdf.parse(sdf.format(new Date()));
        String result = articleController.saveArticle(2,4,create_date,"软件工程","软件工程是一本神奇的书");
        System.out.println(result);
    }

    @Test
    public void testDeleteArticleById() throws Exception{
        ArticleController articleController1 = getArticleController();
        String result = articleController1.deleteArticleById(2);
        System.out.println(result);
    }

    @Test
    public void testUpdateArticle() throws Exception{
        ArticleController articleController1 = getArticleController();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date create_date = sdf.parse(sdf.format(new Date()));
        String result = articleController1.updateArticle(2,2,0,create_date,"操作系统","操作系统精髓与设计原理");
        System.out.println(result);
    }

    private ArticleController getArticleController(){
        if(articleController==null){
            articleController = new ArticleController(articleService);
        }
        return articleController;
    }
}
