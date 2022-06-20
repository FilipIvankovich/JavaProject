package hr.tvz.ivankovic.hardwareapp;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail hardwareJobDetail() {
        return JobBuilder.newJob(HardwareJob.class).withIdentity("hardwareJob").storeDurably().build();
    }

    @Bean
    public SimpleTrigger hardwareJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();
        return TriggerBuilder.newTrigger().forJob(hardwareJobDetail())
                .withIdentity("hardwareTrigger").withSchedule(scheduleBuilder).build();
    }

    @Bean
    public CronTrigger hardwareJobTriggerTwo() {
        return TriggerBuilder.newTrigger().forJob(hardwareJobDetail()).withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 ? * MON,FRI"))
                .withIdentity("hardwareTrigger").build();
    }
}
