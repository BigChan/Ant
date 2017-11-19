package com.ant.entity;

import java.util.Date;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */
public class Article {
    private int id;
    private int user_id;
    private int viewed;
    private Date create_date;
    private String title;
    private String content;

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getUserId(){
        return user_id;
    }
    public void setUserId(int user_id){
        this.user_id = user_id;
    }

    public int getViewed(){
        return viewed;
    }
    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public Date getCreateDate() {
        return create_date;
    }

    public void setCreateDate(Date create_date) {
        this.create_date = create_date;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
