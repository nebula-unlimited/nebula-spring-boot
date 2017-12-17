package com.nebula.service;

import com.nebula.domain.About;
import com.nebula.domain.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    AboutRepository aboutRepository;

    /**
     * 查找全部记录
     * @param pageable
     * @return
     */
    @Override
    public Page<About> findAll(Pageable pageable) {
        return aboutRepository.findAll(pageable);
    }

    /**
     * 根据名称查找记录
     * @param name
     * @return
     */
    @Override
    public List<About> findByName(String name) {
        return aboutRepository.findByName(name);
    }

    /**
     * 自定义查询语句查找对应名称记录
     * @param name
     * @return
     */
    @Override
    public List<About> findByNameQuery(String name) {
        return aboutRepository.findByNameQuery(name);
    }

    /**
     * 根据名称统计记录总数
     * @param name
     * @return
     */
    @Override
    public Long countByName(String name) {
        return aboutRepository.countByName(name);
    }

    /**
     * 自定义查询语句
     * @param id
     * @param name
     * @param content
     * @return
     */
    @Override
    public int customUpdate(Long id, String name, String content) {
        return aboutRepository.customUpdate(id, name, content);
    }

    /**
     * 更新
     * @param about
     * @return
     */
    @Override
    public About save(About about) {
        return aboutRepository.save(about);
    }
}
