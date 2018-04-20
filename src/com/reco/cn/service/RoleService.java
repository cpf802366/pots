package com.reco.cn.service;

import com.reco.cn.domain.RoleDO;

import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */
public interface RoleService {

    RoleDO get(Long roleId);

    List<RoleDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RoleDO role);

    int update(RoleDO role);

    int remove(Long roleId);

    int batchRemove(Long[] roleIds);
}
