package com.nebula.web;

import com.nebula.domain.About;
import com.nebula.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 首页控制器
 *
 * @author Nebula Unlimited
 */

@RestController
public class IndexController {
    @Autowired
    private AboutService aboutService;

    @RequestMapping("/")
    public String index() {
        System.out.println(aboutService.findAll());

        Long id = aboutService.insert("abcd", "content123");
        System.out.println(id);

        About about = new About();
        about.setId(6L);
        about.setName("dcba");
        about.setContent("xxx");
        aboutService.update(about);

        System.out.println(aboutService.findByName("dcba"));

        System.out.println(aboutService.findOne(6));

        aboutService.delete(6L);
        return "ok";
    }
}
