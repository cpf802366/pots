package com.reco.cn.service.impl;

import com.reco.cn.dao.SalesDao;
import com.reco.cn.domain.SalesDO;
import com.reco.cn.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesDao salesDao;

    @Override
    public SalesDO get(Integer soId) {
        return salesDao.get(soId);
    }

    @Override
    public List<SalesDO> list(Map<String, Object> map) {
        return salesDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return salesDao.count(map);
    }

    @Override
    public int save(SalesDO sales) {
        return salesDao.save(sales);
    }

    @Override
    public int update(SalesDO sales) {
        return salesDao.update(sales);
    }

    @Override
    public int remove(Integer soId) {
        return salesDao.remove(soId);
    }

    @Override
    public int batchRemove(Integer[] soIds) {
        return salesDao.batchRemove(soIds);
    }

}
