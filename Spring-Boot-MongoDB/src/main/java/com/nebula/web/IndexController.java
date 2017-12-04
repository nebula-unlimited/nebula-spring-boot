package com.nebula.web;

import com.nebula.domain.User;
import com.nebula.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        userRepository.save(new User(1L, "nebula", 30));
        return "ok";
    }
}
