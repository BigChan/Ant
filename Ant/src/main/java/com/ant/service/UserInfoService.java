package com.ant.service;

public interface UserInfoService {

    String getUserInfo(String username);

    String updateUserInfo(String username,String email, Integer sex, String penname, String introduction, String website);

}
