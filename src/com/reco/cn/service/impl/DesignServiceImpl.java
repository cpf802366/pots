package com.reco.cn.service.impl;

import com.reco.cn.dao.DesignDao;
import com.reco.cn.domain.DesignDO;
import com.reco.cn.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class DesignServiceImpl implements DesignService {
    @Autowired
    private DesignDao designDao;

    @Override
    public DesignDO get(Integer designId) {
        DesignDO designDO = designDao.get(designId);

        return designDao.get(designId);
    }

    @Override
    public List<DesignDO> list(Map<String, Object> map) {
        return designDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return designDao.count(map);
    }

    @Override
    public int save(DesignDO design) {
        return designDao.save(design);
    }

    @Override
    public int update(DesignDO design) {
        return designDao.update(design);
    }

    @Override
    public int remove(Integer designId) {
        return designDao.remove(designId);
    }

    @Override
    public int batchRemove(Integer[] designIds) {
        return designDao.batchRemove(designIds);
    }

}
