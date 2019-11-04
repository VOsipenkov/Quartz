package spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = "spring.cron")
public class ApplicationMain {
    public static void main(String[] args) {
        System.out.println("my-spring-boot started..");
    }
}
