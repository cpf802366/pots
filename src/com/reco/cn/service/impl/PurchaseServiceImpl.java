package com.reco.cn.service.impl;

import com.reco.cn.dao.PurchaseDao;
import com.reco.cn.domain.DesignDO;
import com.reco.cn.domain.PurchaseDO;
import com.reco.cn.domain.SalesDO;
import com.reco.cn.service.DesignService;
import com.reco.cn.service.PurchaseService;
import com.reco.cn.service.SalesService;
import com.reco.cn.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;
    @Autowired
    private DesignService designService;
    @Autowired
    private SalesService salesService;

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

    public R savebyorder(PurchaseDO purchase) {
        Map<String, Object> map = new HashMap<>();
        List<PurchaseDO> ls;

        Map<String, Object> params = new HashMap<>();
        R r = new R();

        DesignDO design = designService.get(purchase.getDesign_id());
        SalesDO salesDO = salesService.get(Integer.parseInt(purchase.getSo_ids()));

        purchase.setOrder_state(1);
        purchase.setPot_id(salesDO.getPotId());
        purchase.setSeller_id(salesDO.getSellerId());
        purchase.setPrice(salesDO.getPrice());
        purchase.setPo_dttm(new Date());

        String po = purchase.getPo_no();
        if (po == null || po.length() <= 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String pre = sdf.format(purchase.getPo_dttm()) + "P";

            map.put("cxtj", "and po_no like '" + pre + "%'");
            map.put("sort", "po_no");
            map.put("order", "desc");

            ls = list(map);

            if (ls.size() == 0)
                po = pre + "0001";
            else {
                po = ls.get(0).getPo_no();
                po = pre + String.format("%04d", (Integer.valueOf(po.substring(9)) + 1));
            }
            purchase.setPo_no(po);
        }



        purchaseDao.save(purchase);
        r = R.ok(po);

        return r;
    }

    @Override
    public R saveByNoAddr(PurchaseDO purchase) {
        Map<String, Object> params = new HashMap<>();
        params.put("po_no", purchase.getPo_no());
        List<PurchaseDO> list = purchaseDao.list(params);
        if (list != null && list.size() > 0) {
            purchase.setPo_id(list.get(0).getPo_id());
            purchaseDao.update(purchase);
            return R.ok();
        } else {
            return R.error();
        }


    }
}
