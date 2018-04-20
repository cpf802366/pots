package com.reco.cn.dao;

import com.reco.cn.domain.UserDO;

import java.util.List;
import java.util.Map;


/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */

public interface UserDao {

    UserDO get(Long userId);

    List<UserDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserDO user);

    int update(UserDO user);

    int remove(Long user_id);

    int batchRemove(Long[] userIds);

    UserDO getByUserDO(UserDO userDO);
}
