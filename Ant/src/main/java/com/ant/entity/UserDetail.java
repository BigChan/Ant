package com.ant.entity;

public class UserDetail {
    private int id;
    private String name;
    private String image;
    private String introduction;
    private char sex;
    private String net;

    public String getNet() {return net;}

    public void setNet(String net) {this.net = net; }

    public char getSex() {return sex;}

    public void setSex(char sex) {this.sex = sex; }

    public int getId() {return id;  }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
