package com.reco.cn.service.impl;

import com.reco.cn.dao.MemDao;
import com.reco.cn.domain.MemDO;
import com.reco.cn.service.MemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MemServiceImpl implements MemService {
    @Autowired
    private MemDao memDao;

    @Override
    public MemDO get(Integer id) {
        return memDao.get(id);
    }

    @Override
    public List<MemDO> list(Map<String, Object> map) {
        return memDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return memDao.count(map);
    }

    @Override
    public int save(MemDO mem) {
        return memDao.save(mem);
    }

    @Override
    public int update(MemDO mem) {
        return memDao.update(mem);
    }

    @Override
    public int remove(Integer id) {
        return memDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return memDao.batchRemove(ids);
    }

}
