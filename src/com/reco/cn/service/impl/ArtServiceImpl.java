package com.reco.cn.service.impl;

import com.reco.cn.dao.ArtDao;
import com.reco.cn.domain.ArtDO;
import com.reco.cn.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ArtServiceImpl implements ArtService {
    @Autowired
    private ArtDao artDao;

    @Override
    public ArtDO get(Integer id) {
        return artDao.get(id);
    }

    @Override
    public List<ArtDO> list(Map<String, Object> map) {
        return artDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return artDao.count(map);
    }

    @Override
    public int save(ArtDO art) {
        return artDao.save(art);
    }

    @Override
    public int update(ArtDO art) {
        return artDao.update(art);
    }

    @Override
    public int remove(Integer id) {
        return artDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return artDao.batchRemove(ids);
    }

}
