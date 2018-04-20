package com.reco.cn.dao;

import com.reco.cn.domain.PriceDO;

import java.util.List;
import java.util.Map;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

public interface PriceDao {

    PriceDO get(Integer priceId);

    List<PriceDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(PriceDO price);

    int update(PriceDO price);

    int remove(Integer price_id);

    int batchRemove(Integer[] priceIds);
}
