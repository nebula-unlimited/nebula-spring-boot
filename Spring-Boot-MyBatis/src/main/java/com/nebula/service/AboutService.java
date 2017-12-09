package com.nebula.service;

import com.nebula.domain.About;

import java.util.List;

/**
 * About 服务层接口
 *
 * @author Nebula Unlimited
 */

public interface AboutService {

    List<About> findAll(About about);

    List<About> findPage(int page, int size);

    About findOne(int id);

    About findByName(String name);

    Long insert(String name, String content);

    int update(About about);

    int delete(Long id);
}
