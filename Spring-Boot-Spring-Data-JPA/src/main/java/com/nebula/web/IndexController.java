package com.nebula.web;

import com.nebula.domain.About;
import com.nebula.domain.AboutRepository;
import com.nebula.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * 首页控制器
 *
 * @author Nebula Unlimited
 */

@RestController
public class IndexController {
    @Autowired
    private AboutService aboutService;

    @Autowired
    private AboutRepository aboutRepository;

    @RequestMapping("/")
    public String index() {

        System.out.println(aboutService.findByName("abcd"));

        System.out.println(aboutService.findByNameQuery("abcd"));

        System.out.println(aboutService.countByName("abcd"));

        System.out.println(aboutService.customUpdate(6L, "dcba", "xxx"));

        System.out.println(aboutRepository.updateStatus(6L, 1));

        About about = aboutRepository.findById(6L).get();
        System.out.println(about);

        about.setName("asdf");
        System.out.println(aboutRepository.save(about));

        return "ok";
    }

    @RequestMapping("insert")
    public String insert() {
        About about = new About();
        about.setCreateTime(new Timestamp(System.currentTimeMillis()));
        about.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        about.setCreateUser(0);
        about.setUpdateUser(0);
        about.setRank(0);
        about.setStatus(0);
        about.setName("abcd");
        about.setContent("content123" + System.currentTimeMillis());
        aboutRepository.save(about);
        return "ok";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        aboutRepository.deleteById(id);
        return "ok";
    }

    /**
     *
     * @param pageable
     * @return
     *
     * 分页：/about?size=3&page=0&sort=id,desc
     *
     * Pageable
     * page: Page you want to retrieve, 0 indexed and defaults to 0.
     * size: Size of the page you want to retrieve, defaults to 20.
     * sort: Properties that should be sorted by in the format property,property(,ASC|DESC).
     * Default sort direction is ascending. Use multiple sort parameters if you want to switch directions,
     * e.g. ?sort=firstname&sort=lastname,asc.
     */
    @RequestMapping("/about")
    public Page<About> about(Pageable pageable) {
        return aboutService.findAll(pageable);
    }

    @RequestMapping("/about/{id}")
    public String aboutDetail(@PathVariable("id") Long id) {
        System.out.println(aboutRepository.findById(id).get());
        return aboutRepository.findById(id).get().toString();
    }
}
