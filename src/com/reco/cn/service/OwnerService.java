package com.reco.cn.service;

import com.reco.cn.domain.OwnerDO;

import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */
public interface OwnerService {

    OwnerDO get(Integer potId);

    List<OwnerDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(OwnerDO owner);

    int update(OwnerDO owner);

    int remove(Integer potId);

    int batchRemove(Integer[] potIds);
}
