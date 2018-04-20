package com.reco.cn.service;

import com.reco.cn.domain.DesignDO;

import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */
public interface DesignService {

    DesignDO get(Integer design_Id);

    List<DesignDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(DesignDO design);

    int update(DesignDO design);

    int remove(Integer design_Id);

    int batchRemove(Integer[] design_Ids);
}
