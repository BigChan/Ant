package com.ant.test;

import com.ant.service.ArticleService;
import com.ant.web.ArticleController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

    }

    @Test
    public void testGetById() throws Exception {

    }

    @Test
    public void testSaveArticle() throws Exception{

    }

    @Test
    public void testDeleteArticleById() throws Exception{

    }

    @Test
    public void testUpdateArticle() throws Exception{

    }

    private ArticleController getArticleController(){
        if(articleController==null){
            articleController = new ArticleController(articleService);
        }
        return articleController;
    }
}
