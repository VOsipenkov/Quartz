package main.method.only;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzByEverySecondTrigger {
    public static void main(String[] args) throws SchedulerException, java.text.ParseException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("Cron trigger").build();
        /* http://www.cronmaker.com/ */
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("CronTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(5))
                .build();

        Scheduler cronScheduler = StdSchedulerFactory.getDefaultScheduler();
        cronScheduler.scheduleJob(jobDetail, trigger);
        cronScheduler.start();
    }
}
