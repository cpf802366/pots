package com.reco.cn.dao;

import com.reco.cn.domain.RoleMenuDO;

import java.util.List;
import java.util.Map;


/**
 * 角色与菜单对应关系
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */

public interface RoleMenuDao {

    RoleMenuDO get(Long id);

    List<RoleMenuDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RoleMenuDO roleMenu);

    int update(RoleMenuDO roleMenu);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
