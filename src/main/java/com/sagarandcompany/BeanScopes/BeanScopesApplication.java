package com.sagarandcompany.BeanScopes;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sagarandcompany.BeanScopes.PrototypeIntoSingletonProblem.UserService;
import com.sagarandcompany.BeanScopes.PrototypeIntoSingletonProblem.Address;

@SpringBootApplication
public class BeanScopesApplication {

    public static void main(String[] args) throws Exception {
//		SpringApplication.run(BeanScopesApplication.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.toString());
        Thread.sleep(1000);
        UserService userService1 = (UserService) context.getBean("userService");
        System.out.println(userService1.toString());
    }
}
