package com.reco.cn.service.impl;

import com.reco.cn.dao.LogDao;
import com.reco.cn.domain.LogDO;
import com.reco.cn.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public LogDO get(Long id) {
        return logDao.get(id);
    }

    @Override
    public List<LogDO> list(Map<String, Object> map) {
        return logDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return logDao.count(map);
    }

    @Override
    public int save(LogDO log) {
        return logDao.save(log);
    }

    @Override
    public int update(LogDO log) {
        return logDao.update(log);
    }

    @Override
    public int remove(Long id) {
        return logDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return logDao.batchRemove(ids);
    }

}
