package com.ant.service;

import com.ant.entity.UserDetail;

public interface UserDetailService {
    UserDetail getUserDetailById(int id);
    boolean deleteUserDetailById(int id);
    boolean updateUserDetail(int id,String name,String image,String introduction,char sex,String net);
    boolean saveUserDetail(int id,String name,String image,String introduction,char sex,String net);
}
