package com.reco.cn.dao;

import com.reco.cn.domain.DictDO;

import java.util.List;
import java.util.Map;


/**
 * 字典表
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

public interface DictDao {

    DictDO get(Long id);

    List<DictDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(DictDO dict);

    int update(DictDO dict);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
