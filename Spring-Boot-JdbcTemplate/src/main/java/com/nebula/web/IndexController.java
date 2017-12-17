package com.nebula.web;

import com.nebula.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    AboutService aboutService;

    @RequestMapping("/findall")
    public String findAll() {
        return aboutService.findAll().toString();
    }

    @RequestMapping("findone/{id}")
    public String findOne(@PathVariable("id") Long id) {
        return aboutService.findOne(id).toString();
    }

    @RequestMapping("create")
    public String create() {
        return aboutService.create("abcd", "content123").toString();
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") Long id) {
        return aboutService.update(id, "asdf", "xxx").toString();
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return aboutService.delete(id).toString();
    }

    @RequestMapping("/count")
    public String count() {
        return aboutService.count().toString();
    }
}
