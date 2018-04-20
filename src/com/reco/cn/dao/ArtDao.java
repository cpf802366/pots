package com.reco.cn.dao;

import com.reco.cn.domain.ArtDO;

import java.util.List;
import java.util.Map;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */

public interface ArtDao {

    ArtDO get(Integer id);

    List<ArtDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ArtDO art);

    int update(ArtDO art);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
