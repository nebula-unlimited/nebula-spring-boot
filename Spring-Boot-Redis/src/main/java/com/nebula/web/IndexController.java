package com.nebula.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class IndexController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/")
    public String index() {
        /**
         * StringRedisTemplate 针对 jedis 客户端中大量 api 进行了归类封装,将同一类型操作封装为 operation 接口
         * ValueOperations：简单K-V操作
         * SetOperations：set类型数据操作
         * ZSetOperations：zset类型数据操作
         * HashOperations：针对map类型的数据操作
         * ListOperations：针对list类型的数据操作
         */
        // 写入字符串
        stringRedisTemplate.opsForValue().set("a", "123");
        // 获取字符串
        String a = stringRedisTemplate.opsForValue().get("a");
        // 删除字符串
        stringRedisTemplate.delete("a");

        // 写入字符串和设置缓存时间
        stringRedisTemplate.opsForValue().set("test", "100", 60 * 2, TimeUnit.SECONDS);

        // val 做 - 1 操作
        stringRedisTemplate.boundValueOps("test").increment(-1);

        // 根据 key 获取缓存中的 val
        stringRedisTemplate.opsForValue().get("test");

        // val + 1
        stringRedisTemplate.boundValueOps("test").increment(1);

        // 根据 key 获取过期时间
        stringRedisTemplate.getExpire("test");

        // 根据 key 获取过期时间并换算成指定单位
        stringRedisTemplate.getExpire("test", TimeUnit.SECONDS);

        // 根据 key 删除缓存
        stringRedisTemplate.delete("test");

        // 检查 key 是否存在，返回 boolean 值
        stringRedisTemplate.hasKey("546545");

        // 向指定 key 中存放 set 集合
        stringRedisTemplate.opsForSet().add("red_123", "1", "2", "3");

        // 设置过期时间
        stringRedisTemplate.expire("red_123", 1000, TimeUnit.MILLISECONDS);

        // 根据 key 查看集合中是否存在指定数据
        stringRedisTemplate.opsForSet().isMember("red_123", "1");

        // 根据 key 获取 set 集合
        stringRedisTemplate.opsForSet().members("red_123");

        return a;
    }
}
