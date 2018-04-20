package com.reco.cn.service.impl;

import com.reco.cn.dao.RoleMenuDao;
import com.reco.cn.domain.RoleMenuDO;
import com.reco.cn.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    public RoleMenuDO get(Long id) {
        return roleMenuDao.get(id);
    }

    @Override
    public List<RoleMenuDO> list(Map<String, Object> map) {
        return roleMenuDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return roleMenuDao.count(map);
    }

    @Override
    public int save(RoleMenuDO roleMenu) {
        return roleMenuDao.save(roleMenu);
    }

    @Override
    public int update(RoleMenuDO roleMenu) {
        return roleMenuDao.update(roleMenu);
    }

    @Override
    public int remove(Long id) {
        return roleMenuDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return roleMenuDao.batchRemove(ids);
    }

}
