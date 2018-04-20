package com.reco.cn.service.impl;

import com.reco.cn.dao.MenuDao;
import com.reco.cn.domain.MenuDO;
import com.reco.cn.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public MenuDO get(Long menuId) {
        return menuDao.get(menuId);
    }

    @Override
    public List<MenuDO> list(Map<String, Object> map) {
        return menuDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return menuDao.count(map);
    }

    @Override
    public int save(MenuDO menu) {
        return menuDao.save(menu);
    }

    @Override
    public int update(MenuDO menu) {
        return menuDao.update(menu);
    }

    @Override
    public int remove(Long menuId) {
        return menuDao.remove(menuId);
    }

    @Override
    public int batchRemove(Long[] menuIds) {
        return menuDao.batchRemove(menuIds);
    }

}
