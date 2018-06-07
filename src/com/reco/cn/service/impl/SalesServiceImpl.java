package com.reco.cn.service.impl;

import com.reco.cn.dao.SalesDao;
import com.reco.cn.domain.SalesDO;
import com.reco.cn.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
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
        Map<String, Object> map = new HashMap<>();
        List<SalesDO> ls;
        String so = sales.getSoNo();
        if (so == null || so.length() <= 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String pre = sdf.format(sales.getSellDttm()) + "S";

            map.put("cxtj", "and so_no like '" + pre + "%'");
            map.put("sort", "so_no");
            map.put("order", "desc");

            ls = list(map);

            if (ls.size() == 0)
                so = pre + "0001";
            else {
                so = ls.get(0).getSoNo();
                so = pre + String.format("%04d", (Integer.valueOf(so.substring(9)) + 1));
            }
            sales.setSoNo(so);
        }
/*
        if (sales.getSo_id() == null) {
            map.clear();
            map.put("sort", "so_id");
            map.put("order", "desc");

            ls = list(map);

            sales.setSo_id(ls.get(0).getSo_id() + 1);
        }
*/
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
