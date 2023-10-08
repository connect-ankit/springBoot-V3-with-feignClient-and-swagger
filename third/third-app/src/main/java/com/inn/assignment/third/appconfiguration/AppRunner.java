package com.inn.assignment.third.appconfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@EnableFeignClients

@SpringBootApplication
@ComponentScan(basePackages = { "com.inn" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class})
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

