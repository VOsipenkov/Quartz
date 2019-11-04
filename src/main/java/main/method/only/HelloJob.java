package main.method.only;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.time.LocalDateTime;

public class HelloJob implements Job {
    public void execute(JobExecutionContext context) {
        System.out.println("hello by Quartz without frameworks");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.format("time:%s%n", localDateTime);
    }
}
