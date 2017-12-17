package com.nebula.service;

import com.nebula.domain.About;

import java.util.List;

/**
 * About 服务层接口
 *
 * @author Nebula Unlimited
 */

public interface AboutService {
    /**
     * 查找全部记录
     * @param about
     * @return
     */
    List<About> findAll(About about);

    /**
     * 分页查找
     * @param page
     * @param size
     * @return
     */
    List<About> findPage(int page, int size);

    /**
     * 查找一条记录
     * @param id
     * @return
     */
    About findOne(int id);

    /**
     * 根据名称查找记录
     * @param name
     * @return
     */
    About findByName(String name);

    /**
     * 创建
     * @param name
     * @param content
     * @return
     */
    Long insert(String name, String content);

    /**
     * 更新
     * @param about
     * @return
     */
    int update(About about);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);
}
