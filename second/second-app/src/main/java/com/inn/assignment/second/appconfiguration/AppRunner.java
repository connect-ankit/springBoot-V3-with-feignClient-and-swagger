package com.inn.assignment.second.appconfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = { "com.inn" })
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@EnableFeignClients
public class AppRunner {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AppRunner.class, args);
        //displayAllBeans(applicationContext);
    }

    public static void displayAllBeans(ApplicationContext applicationContext) {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }
}

