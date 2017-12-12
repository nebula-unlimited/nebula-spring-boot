package com.nebula.service;

import com.nebula.domain.About;

import java.util.List;
import java.util.Map;

public interface AboutService {
    List<About> findAll();

    Map findOne(Long id);

    Integer create(String name, String content);

    Integer update(Long id, String name, String content);

    Integer delete(Long id);

    Integer count();
}
