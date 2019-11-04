package main.method.only;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {
    public static void main(String[] args) throws SchedulerException {
        JobDetail simpleJobDetail = JobBuilder
                .newJob(HelloJob.class)
                .build();

        Trigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("SimpleTrigger")
                .build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(simpleJobDetail, simpleTrigger);
        scheduler.start();
    }
}
