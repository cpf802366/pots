package com.reco.cn.service;

import com.reco.cn.domain.MemDO;

import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */
public interface MemService {

    MemDO get(Integer id);

    List<MemDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(MemDO mem);

    int update(MemDO mem);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
