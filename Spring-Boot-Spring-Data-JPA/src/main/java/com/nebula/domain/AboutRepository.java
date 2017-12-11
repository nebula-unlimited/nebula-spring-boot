package com.nebula.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * About 资源库
 *
 * @author Nebula Unlimited
 */

@Transactional
@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
    List<About> findByName(@Param("name") String name);

    @Query("select u from #{#entityName} u where u.name = ?1")
    List<About> findByNameQuery(String name);

    Long countByName(String name);

    @Modifying
    @Query("update #{#entityName} set name = :name, content = :content where id = :id")
    int customUpdate(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("content") String content
    );

    @Modifying
    @Query("update #{#entityName} u set u.status = ?2 where u.id = ?1")
    int updateStatus(Long id, int status);
}
