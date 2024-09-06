package com.sky.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义定时任务类
 */
@Component
@Slf4j
public class Mytask {
    @Scheduled(cron = "0/1 * * * * ?")
    public void executeTask() {
        log.info("{}", LocalDateTime.now());
    }
}
