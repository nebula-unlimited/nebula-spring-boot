package com.nebula.service;

import com.nebula.domain.About;
import com.nebula.domain.AboutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * About 服务层接口实现类
 *
 * @author Nebula Unlimited
 */

@Service
public class AboutServiceImpl implements AboutService {
    @Autowired
    private AboutMapper aboutMapper;

    @Override
    public List<About> findAll() {
        return aboutMapper.findAll();
    }

    @Override
    public About findOne(int id) {
        return aboutMapper.findOne(id);
    }

    @Override
    public About findByName(String name) {
        return aboutMapper.findByName(name);
    }

    @Override
    public Long insert(String name, String content) {
       return aboutMapper.insert(name, content);
    }

    @Override
    public int update(About about) {
        return aboutMapper.update(about);
    }

    @Override
    public int delete(Long id) {
        return aboutMapper.delete(id);
    }
}
