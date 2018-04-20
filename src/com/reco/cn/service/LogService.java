package com.reco.cn.service;

import com.reco.cn.domain.LogDO;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */
public interface LogService {

    LogDO get(Long id);

    List<LogDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(LogDO log);

    int update(LogDO log);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
