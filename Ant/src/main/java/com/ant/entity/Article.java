package com.ant.entity;

import java.util.Date;

/**
 * <p>
 * Created by ChenZhaoqiang.
 */
public class Article {

    private int id;
    private String username;
    private int views;
    private Date createDate;
    private String title;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "id:" + getId() + "\n" +
                "username:" + getUsername() + "\n" +
                "views:" + getViews() + "\n" +
                "createdate:" + getCreateDate().toString() + "\n" +
                "title:" + getTitle() + "\n" +
                "content:" + getContent() + "\n";
    }
}
