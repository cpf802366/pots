package com.reco.cn.service.impl;

import com.reco.cn.dao.MemAddrDao;
import com.reco.cn.domain.MemAddrDO;
import com.reco.cn.service.MemAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MemAddrServiceImpl implements MemAddrService {
    @Autowired
    private MemAddrDao memAddrDao;

    @Override
    public MemAddrDO get(Integer id) {
        return memAddrDao.get(id);
    }

    @Override
    public List<MemAddrDO> list(Map<String, Object> map) {
        return memAddrDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return memAddrDao.count(map);
    }

    @Override
    public int save(MemAddrDO memAddr) {
        return memAddrDao.save(memAddr);
    }

    @Override
    public int update(MemAddrDO memAddr) {
        return memAddrDao.update(memAddr);
    }

    @Override
    public int remove(Integer id) {
        return memAddrDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return memAddrDao.batchRemove(ids);
    }

    @Override
    public void defaultDz(Integer id, Map<String, Object> map) {
        List<MemAddrDO> list = memAddrDao.list(map);
        for (MemAddrDO memAddrDo:list) {
             if (memAddrDo.getId() .equals(id)  ){
                 memAddrDo.setDefaultdz(1);
             }else{
                 memAddrDo.setDefaultdz(0);
             }
            memAddrDao.update(memAddrDo);
        }
    }


}
