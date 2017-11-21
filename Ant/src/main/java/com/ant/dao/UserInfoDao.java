package com.ant.dao;

import com.ant.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Created by DengWeijian.
 */
public interface UserInfoDao {

    UserInfo getUserInfo(@Param("username") String username);

    void updateUserInfo(UserInfo userInfo);

}
