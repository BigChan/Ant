package com.ant.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ant.dao.UserInfoDao;
import com.ant.entity.UserInfo;
import com.ant.service.UserInfoService;
import com.ant.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    public UserInfoDao userInfoDao;

    @Override
    public String getUserInfo(String username) {
        Map<String, Object> map = new HashMap<>();
        UserInfo userInfo = userInfoDao.getUserInfo(username);
        if (userInfo == null) {
            map.put("code", 0);
            map.put("message", "信息获取失败");
            map.put("info", null);
            return JsonUtils.toJsonString(map);
        } else {
            map.put("code", 1);
            map.put("message", "信息获取成功");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", userInfo.getId());
            jsonObject.put("username", userInfo.getUsername());
            jsonObject.put("email", userInfo.getEmail());
            jsonObject.put("penname", userInfo.getPenname());
            jsonObject.put("avator", userInfo.getAvator() == null ? "" : userInfo.getAvator());
            jsonObject.put("introduction", userInfo.getIntroduction() == null ? "" : userInfo.getIntroduction());
            jsonObject.put("sex", userInfo.getSex());
            jsonObject.put("website", userInfo.getWebsite() == null ? "" : userInfo.getWebsite());

            map.put("info", jsonObject);
        }
        return JsonUtils.toJsonString(map);
    }

    @Override
    public String updateUserInfo(String username,String email, Integer sex, String penname, String introduction, String website) {
        Map<String, Object> map = new HashMap<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setEmail(email);
        userInfo.setSex(sex);
        userInfo.setPenname(penname);
        userInfo.setIntroduction(introduction);
        userInfo.setWebsite(website);
        userInfoDao.updateUserInfo(userInfo);
        map.put("code",1);
        map.put("message","用户信息修改成功");
        return JsonUtils.toJsonString(map);
    }
}
