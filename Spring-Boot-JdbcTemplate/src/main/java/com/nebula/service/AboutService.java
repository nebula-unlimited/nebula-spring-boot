package com.nebula.service;

import com.nebula.domain.About;

import java.util.List;
import java.util.Map;

/**
 * About 服务层接口
 *
 * @author Nebula Unlimited
 */

public interface AboutService {
    /**
     * 查找全部记录
     * @return
     */
    List<About> findAll();

    /**
     * 查找一条记录
     * @param id
     * @return
     */
    Map findOne(Long id);

    /**
     * 创建
     * @param name
     * @param content
     * @return
     */
    Integer create(String name, String content);

    /**
     * 更新
     * @param id
     * @param name
     * @param content
     * @return
     */
    Integer update(Long id, String name, String content);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer delete(Long id);

    /**
     * 统计记录总数
     * @return
     */
    Integer count();
}
