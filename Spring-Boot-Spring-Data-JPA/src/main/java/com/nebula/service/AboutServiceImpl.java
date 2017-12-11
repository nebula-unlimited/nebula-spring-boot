package com.nebula.service;

import com.nebula.domain.About;
import com.nebula.domain.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutServiceImpl implements AboutService {
    @Autowired
    AboutRepository aboutRepository;

    @Override
    public Page<About> findAll(Pageable pageable) {
        return aboutRepository.findAll(pageable);
    }

    @Override
    public List<About> findByName(String name) {
        return aboutRepository.findByName(name);
    }

    @Override
    public List<About> findByNameQuery(String name) {
        return aboutRepository.findByNameQuery(name);
    }

    @Override
    public Long countByName(String name) {
        return aboutRepository.countByName(name);
    }

    @Override
    public int customUpdate(Long id, String name, String content) {
        return aboutRepository.customUpdate(id, name, content);
    }

    @Override
    public About save(About about) {
        return aboutRepository.save(about);
    }
}
