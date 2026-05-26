package com.example.Task;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpDataTodayAndAllTurnover {

//    @Scheduled(cron = "0 0 0 * * ?") 作用:从左到右，依次为:秒 分 时 日 月 周  定时任务
//    查询总计营业额,每隔12小时更新一次,任务启动后立即执行一次
    @Scheduled(fixedDelay = 12 * 60 * 60 * 1000)/* 12小时更新一次*/
    public void upDataTodayAndAllTurnover(){// 定时任务，12小时更新一次，启动后立即执行一次，查询总营业额
        log.info("开始更新总计营业额");
    }
//    查询当日营业额，每隔10分钟更新一次，启动后立即执行一次
    @Scheduled(fixedDelay = 10 * 60 * 1000)
    public void upDataTodayTurnover(){// 定时任务，10分钟更新一次，启动后立即执行一次，查询当日营业额
        log.info("开始更新当日营业额");
    }

//    启动后立即执行一次
//    @PostConstruct
//    public void init(){
//        log.info("定时任务启动");
//        upDataTodayAndAllTurnover();
//        upDataTodayTurnover();
//    }
}
