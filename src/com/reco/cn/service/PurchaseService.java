package com.reco.cn.service;

import com.reco.cn.domain.PurchaseDO;
import com.reco.cn.util.R;

import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */
public interface PurchaseService {

    PurchaseDO get(Integer poId);

    List<PurchaseDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(PurchaseDO purchase);

    int update(PurchaseDO purchase);

    int remove(Integer poId);

    int batchRemove(Integer[] poIds);
      R savebyorder(PurchaseDO purchase);
    R saveByNoAddr(PurchaseDO purchase);
}
