package com.nebula.web;

import com.nebula.domain.User;
import com.nebula.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页控制器
 *
 * @author Nebula Unlimited
 */

@RestController
public class IndexController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        // 创建三个 User 并验证 User 总数
        userRepository.save(new User(1L, "nebula", 30));
        userRepository.save(new User(2L, "aaa", 20));
        userRepository.save(new User(3L, "bbb", 10));
        System.out.println(userRepository.findAll().size());

        // 删除一个 User 输出 User 总数
        User user = userRepository.findOne(2L);
        userRepository.delete(user);
        System.out.println(userRepository.findAll().size());

        // 再删除一个 User 输出 User 总数
        user = userRepository.findByUsername("bbb");
        userRepository.delete(user);
        System.out.println(userRepository.findAll().size());

        return "ok";
    }
}
