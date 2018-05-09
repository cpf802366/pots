package com.reco.cn.dao;

import com.reco.cn.domain.PriceDO;

import java.util.List;
import java.util.Map;


/**
 * 
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-25 22:49:24
 */

public interface PriceDao {

	PriceDO get(Integer priceid);
	
	List<PriceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PriceDO price);
	
	int update(PriceDO price);
	
	int remove(Integer priceid);
	
	int batchRemove(Integer[] priceids);
	List<PriceDO> salesPrice(Integer designid);
}
