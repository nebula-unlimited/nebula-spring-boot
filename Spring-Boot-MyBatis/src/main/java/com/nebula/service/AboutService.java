package com.nebula.service;

import com.nebula.domain.About;

import java.util.List;

/**
 * About 服务层接口
 *
 * @author Nebula Unlimited
 */

public interface AboutService {

    List<About> findAll();

    About findOne(int id);

    About findByName(String name);

    Long insert(String name, String content);

    int update(About about);

    int delete(Long id);
}
