package com.reco.cn.service.impl;

import com.reco.cn.dao.UserDao;
import com.reco.cn.domain.UserDO;
import com.reco.cn.service.UserService;
import com.reco.cn.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDO get(Long userId) {
        return userDao.get(userId);
    }

    @Override
    public List<UserDO> list(Map<String, Object> map) {
        return userDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userDao.count(map);
    }

    @Override
    public int save(UserDO user) {
        user.setStatus(1);
        user.setUsername(user.getName());
        user.setPassword(Md5Utils.getMD5(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public int update(UserDO user) {
        return userDao.update(user);
    }

    @Override
    public int remove(Long userId) {
        return userDao.remove(userId);
    }

    @Override
    public int batchRemove(Long[] userIds) {
        return userDao.batchRemove(userIds);
    }

    @Override
    public UserDO getByUserDO(UserDO userDO) {
        UserDO byUserDO = userDao.getByUserDO(userDO);


        return userDao.getByUserDO(userDO);
    }

}
