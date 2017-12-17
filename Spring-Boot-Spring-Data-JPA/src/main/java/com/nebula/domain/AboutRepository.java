package com.nebula.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * About 资源库
 *
 * @author Nebula Unlimited
 */

@Transactional(rollbackFor = Exception.class)
@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
    /**
     * 根据名称查找记录
     * @param name
     * @return
     */
    List<About> findByName(@Param("name") String name);

    /**
     * 自定义查询语句查找对应名称记录
     * @param name
     * @return
     */
    @Query("select u from #{#entityName} u where u.name = ?1")
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
    @Modifying
    @Query("update #{#entityName} set name = :name, content = :content where id = :id")
    int customUpdate(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("content") String content
    );

    /**
     * 自定义查询语句更新状态
     * @param id
     * @param status
     * @return
     */
    @Modifying
    @Query("update #{#entityName} u set u.status = ?2 where u.id = ?1")
    int updateStatus(Long id, int status);
}
