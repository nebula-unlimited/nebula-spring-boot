package com.nebula.service;

import com.nebula.domain.About;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * About 服务层接口
 *
 * @author Nebula Unlimited
 */

public interface AboutService {
    /**
     * 查找全部记录
     * @param pageable
     * @return
     */
    Page<About> findAll(Pageable pageable);

    /**
     * 根据名称查找记录
     * @param name
     * @return
     */
    List<About> findByName(String name);

    /**
     * 自定义查询语句查找对应名称记录
     * @param name
     * @return
     */
    List<About> findByNameQuery(String name);

    /**
     * 根据名称统计记录总数
     * @param name
     * @return
     */
    Long countByName(String name);

    /**
     * 自定义查询语句
     * @param id
     * @param name
     * @param content
     * @return
     */
    int customUpdate(Long id, String name, String content);

    /**
     * 更新
     * @param about
     * @return
     */
    About save(About about);
}
