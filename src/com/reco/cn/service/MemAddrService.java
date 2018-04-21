package com.reco.cn.service;

import com.reco.cn.domain.MemAddrDO;

import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */
public interface MemAddrService {

    MemAddrDO get(Integer id);

    List<MemAddrDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(MemAddrDO memAddr);

    int update(MemAddrDO memAddr);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

    void defaultDz (Integer id,Map<String, Object> map);
}
