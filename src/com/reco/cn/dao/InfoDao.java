package com.reco.cn.dao;

import com.reco.cn.domain.InfoDO;

import java.util.List;
import java.util.Map;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

public interface InfoDao {

    InfoDO get(Integer potId);

    List<InfoDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(InfoDO info);

    int update(InfoDO info);

    int remove(Integer pot_id);

    int batchRemove(Integer[] potIds);
}
