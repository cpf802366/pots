package com.reco.cn.service.impl;

import com.reco.cn.dao.OwnerDao;
import com.reco.cn.domain.OwnerDO;
import com.reco.cn.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerDao ownerDao;

    @Override
    public OwnerDO get(Integer potId) {
        return ownerDao.get(potId);
    }

    @Override
    public List<OwnerDO> list(Map<String, Object> map) {
        return ownerDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return ownerDao.count(map);
    }

    @Override
    public int save(OwnerDO owner) {
        return ownerDao.save(owner);
    }

    @Override
    public int update(OwnerDO owner) {
        return ownerDao.update(owner);
    }

    @Override
    public int remove(Integer potId) {
        return ownerDao.remove(potId);
    }

    @Override
    public int batchRemove(Integer[] potIds) {
        return ownerDao.batchRemove(potIds);
    }

}
