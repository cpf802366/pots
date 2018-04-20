package com.reco.cn.service;

import com.reco.cn.domain.FileDO;

import java.util.List;
import java.util.Map;

/**
 * 文件上传
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */
public interface FileService {

    FileDO get(Long id);

    List<FileDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(FileDO file);

    int update(FileDO file);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
