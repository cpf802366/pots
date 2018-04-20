package com.reco.cn.service;

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
public interface MenuService {

    MenuDO get(Long menuId);

    List<MenuDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(MenuDO menu);

    int update(MenuDO menu);

    int remove(Long menuId);

    int batchRemove(Long[] menuIds);
}
