package com.nebula.web;

import com.github.pagehelper.PageInfo;
import com.nebula.domain.About;
import com.nebula.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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

    /**
     * 关于我们列表
     * @param about
     * @return
     *
     * 分页：/about?page=1
     */
    @RequestMapping("/about")
    public PageInfo<About> about(About about) {
        List<About> aboutList = aboutService.findAll(about);
        System.out.println(aboutList);
        return new PageInfo<About>(aboutList);
    }

    @RequestMapping("/about2")
    public List<About> about2() {
        return aboutService.findPage(1, 5);
    }

    /**
     * 删除记录
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String index(@PathVariable Long id) {
        aboutService.delete(id);
        return "ok";
    }
}
