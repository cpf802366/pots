package com.reco.cn.service.impl;

import com.reco.cn.dao.DictDao;
import com.reco.cn.domain.DictDO;
import com.reco.cn.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictDao dictDao;

    @Override
    public DictDO get(Long id) {
        return dictDao.get(id);
    }

    @Override
    public List<DictDO> list(Map<String, Object> map) {
        return dictDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dictDao.count(map);
    }

    @Override
    public int save(DictDO dict) {
        return dictDao.save(dict);
    }

    @Override
    public int update(DictDO dict) {
        return dictDao.update(dict);
    }

    @Override
    public int remove(Long id) {
        return dictDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return dictDao.batchRemove(ids);
    }

}
