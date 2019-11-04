package main.method.only;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzByCronTrigger {
    public static void main(String[] args) throws org.quartz.SchedulerException, java.text.ParseException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("Cron trigger").build();
        /* http://www.cronmaker.com/ */
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("CronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0 0/1 * 1/1 * ? *")))/* every minute */
                .build();

        Scheduler cronScheduler = StdSchedulerFactory.getDefaultScheduler();
        cronScheduler.scheduleJob(jobDetail, trigger);
        cronScheduler.start();
    }
}
