package com.reco.cn.service.impl;

import com.reco.cn.dao.InfoDao;
import com.reco.cn.domain.InfoDO;
import com.reco.cn.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoDao infoDao;

    @Override
    public InfoDO get(Integer potId) {
        return infoDao.get(potId);
    }

    @Override
    public List<InfoDO> list(Map<String, Object> map) {
        return infoDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return infoDao.count(map);
    }

    @Override
    public int save(InfoDO info) {
        return infoDao.save(info);
    }

    @Override
    public int update(InfoDO info) {
        return infoDao.update(info);
    }

    @Override
    public int remove(Integer potId) {
        return infoDao.remove(potId);
    }

    @Override
    public int batchRemove(Integer[] potIds) {
        return infoDao.batchRemove(potIds);
    }

}
