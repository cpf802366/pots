package com.reco.cn.dao;

import com.reco.cn.domain.MenuDO;

import java.util.List;
import java.util.Map;


/**
 * 菜单管理
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */

public interface MenuDao {

    MenuDO get(Long menuId);

    List<MenuDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(MenuDO menu);

    int update(MenuDO menu);

    int remove(Long menu_id);

    int batchRemove(Long[] menuIds);
}
