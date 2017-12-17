package com.nebula.service;

import com.nebula.domain.About;
import com.nebula.domain.AboutRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * About 服务层接口实现类
 *
 * @author Nebula Unlimited
 */

@Service
public class AboutServiceImpl implements AboutService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 查找全部记录
     * @return
     */
    @Override
    public List<About> findAll() {
        return jdbcTemplate.query("select * from nebula_about", new AboutRowMapper());
    }

    /**
     * 查找一条记录
     * @param id
     * @return
     */
    @Override
    public Map findOne(Long id) {
        return jdbcTemplate.queryForMap("select * from nebula_about where id = ?", id);
    }

    /**
     * 创建
     * @param name
     * @param content
     * @return
     */
    @Override
    public Integer create(String name, String content) {
        return jdbcTemplate.update("insert into nebula_about (name, content) values (?, ?)", name, content);
    }

    /**
     * 更新
     * @param id
     * @param name
     * @param content
     * @return
     */
    @Override
    public Integer update(Long id, String name, String content) {
        return jdbcTemplate.update("update nebula_about set name = ?, content = ? where id = ?", name, content, id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public Integer delete(Long id) {
        return jdbcTemplate.update("delete from nebula_about where id = ?", id);
    }

    /**
     * 统计记录总数
     * @return
     */
    @Override
    public Integer count() {
        return jdbcTemplate.queryForObject("select count(*) from nebula_about", Integer.class);
    }
}
