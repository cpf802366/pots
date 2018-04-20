package com.reco.cn.service.impl;

import com.reco.cn.dao.PurchaseDao;
import com.reco.cn.domain.PurchaseDO;
import com.reco.cn.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;

    @Override
    public PurchaseDO get(Integer poId) {
        return purchaseDao.get(poId);
    }

    @Override
    public List<PurchaseDO> list(Map<String, Object> map) {
        return purchaseDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return purchaseDao.count(map);
    }

    @Override
    public int save(PurchaseDO purchase) {
        return purchaseDao.save(purchase);
    }

    @Override
    public int update(PurchaseDO purchase) {
        return purchaseDao.update(purchase);
    }

    @Override
    public int remove(Integer poId) {
        return purchaseDao.remove(poId);
    }

    @Override
    public int batchRemove(Integer[] poIds) {
        return purchaseDao.batchRemove(poIds);
    }

}
