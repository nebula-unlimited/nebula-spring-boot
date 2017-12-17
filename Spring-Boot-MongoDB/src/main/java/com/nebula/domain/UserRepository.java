package com.nebula.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * User 资源库
 *
 * @author Nebula Unlimited
 */

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    /**
     * 根据用户名查找用户记录
     * @param username
     * @return
     */
    User findByUsername(String username);
}
