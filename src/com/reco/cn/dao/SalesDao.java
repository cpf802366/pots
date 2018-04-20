package com.reco.cn.dao;

import com.reco.cn.domain.SalesDO;

import java.util.List;
import java.util.Map;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

public interface SalesDao {

    SalesDO get(Integer soId);

    List<SalesDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(SalesDO sales);

    int update(SalesDO sales);

    int remove(Integer so_id);

    int batchRemove(Integer[] soIds);
}
