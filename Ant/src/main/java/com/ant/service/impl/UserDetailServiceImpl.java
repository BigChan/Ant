package com.ant.service.impl;

import com.ant.dao.UserDetailDao;
import com.ant.entity.UserDetail;
import com.ant.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    public UserDetailDao userDetailDao;

    @Override
    public UserDetail getUserDetailById(int id) {
        UserDetail userDetail = userDetailDao.getUserDetailById(id);
        return userDetail;
    }

    @Override
    public boolean deleteUserDetailById(int id) {
        UserDetail userDetail = userDetailDao.getUserDetailById(id);
        boolean isTrue = false;
        if(userDetail!=null){
            userDetailDao.deleteUserDetailById(id);
            isTrue = true;
        }
        return isTrue;
    }

    @Override
    public boolean updateUserDetail(int id, String name, String image, String introduction) {
        UserDetail userDetail = userDetailDao.getUserDetailById(id);
        boolean isTrue = false;
        if(userDetail!=null){
            userDetailDao.updateUserDetail(id,name,image,introduction);
            isTrue = true;
        }
        return isTrue;
    }

    @Override
    public boolean saveUserDetail(int id,String name, String image, String introduction) {
        UserDetail userDetail = userDetailDao.getUserDetailById(id);
        boolean isTrue = false;
        if(userDetail==null) {
            userDetailDao.saveUserDetail(id, name, image, introduction);
            isTrue = true;
        }
        return isTrue;
    }
}
