package com.nebula.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页控制器
 *
 * @author Nebula Unlimited
 */

@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "hello";
    }
}
