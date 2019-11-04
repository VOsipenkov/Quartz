package spring.cron;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzComponent {
    @Bean
    public JobDetail cronJob() {
        return JobBuilder.newJob(HelloJob.class).withIdentity("helloJob").build();
    }

    @Bean
    public Trigger cronTrigger() {
        return TriggerBuilder
                .newTrigger()
                .withIdentity("cronTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(5)).build();
    }

    @Bean
    public Scheduler cronScheduler(JobDetail cronJob, Trigger cronTrigger) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(cronJob, cronTrigger);
        scheduler.start();
        return scheduler;
    }
}
