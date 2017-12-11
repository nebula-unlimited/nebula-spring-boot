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
    Page<About> findAll(Pageable pageable);

    List<About> findByName(String name);

    List<About> findByNameQuery(String name);

    Long countByName(String name);

    int customUpdate(Long id, String name, String content);

    About save(About about);
}
