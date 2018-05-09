package com.reco.cn.service.impl;

import com.reco.cn.dao.PriceDao;
import com.reco.cn.domain.PriceDO;
import com.reco.cn.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceDao priceDao;

    @Override
    public PriceDO get(Integer priceId) {
        return priceDao.get(priceId);
    }

    @Override
    public List<PriceDO> list(Map<String, Object> map) {
        return priceDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return priceDao.count(map);
    }

    @Override
    public int save(PriceDO price) {
        return priceDao.save(price);
    }

    @Override
    public int update(PriceDO price) {
        return priceDao.update(price);
    }

    @Override
    public int remove(Integer priceId) {
        return priceDao.remove(priceId);
    }

    @Override
    public int batchRemove(Integer[] priceIds) {
        return priceDao.batchRemove(priceIds);
    }

    @Override
    public List<PriceDO> salesPrice(Integer designid) {
        return   priceDao.salesPrice(designid);
    }

}
