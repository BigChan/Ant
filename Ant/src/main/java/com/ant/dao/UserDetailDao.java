package com.ant.dao;

import com.ant.entity.UserDetail;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Created by DengWeijian.
 */
public interface UserDetailDao {
    UserDetail getUserDetailById(@Param("id") int id);
    void deleteUserDetailById(@Param("id") int id);
    void updateUserDetail(@Param("id") int id,@Param("name") String name,@Param("image") String image,@Param("introduction") String introduction,@Param("sex")char sex,@Param("net") String net);
    void saveUserDetail(@Param("id")int id,@Param("name") String name,@Param("image") String image,@Param("introduction") String introduction,@Param("sex")char sex,@Param("net") String net);
}
