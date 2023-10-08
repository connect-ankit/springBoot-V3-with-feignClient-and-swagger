package com.inn.assignment.first.appconfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = { "com.inn" })
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@EnableFeignClients(basePackages={"com.inn"})
@EnableJpaRepositories(basePackages = "com.inn.assignment")
@EntityScan("com.inn.assignment")
public class AppRunner {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AppRunner.class, args);
       // displayAllBeans(applicationContext);
    }

    public static void displayAllBeans(ApplicationContext applicationContext) {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }
    
    
    
    @Bean
	 @LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
    
    
   
}

