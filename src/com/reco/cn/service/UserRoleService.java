package com.reco.cn.service;

import com.reco.cn.domain.UserRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */
public interface UserRoleService {

    UserRoleDO get(Long id);

    List<UserRoleDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserRoleDO userRole);

    int update(UserRoleDO userRole);

    int remove(Long id);

    int batchRemove(Long[] ids);


}
