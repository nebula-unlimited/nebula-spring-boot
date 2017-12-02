package com.nebula.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务实现类
 *
 * @author Nebula Unlimited
 */

@Component
public class SchedulerTask {

    /**
     * fixedRate 说明
     *
     * @Scheduled(fixedRate = 6000)：上一次开始执行时间点之后6秒再执行
     * @Scheduled(fixedDelay = 6000)：上一次执行完毕时间点之后6秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=6000)：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行
     */

    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task runing  " + (count++));
    }

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
