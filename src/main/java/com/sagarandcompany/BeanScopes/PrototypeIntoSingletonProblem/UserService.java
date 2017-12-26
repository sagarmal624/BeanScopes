package com.sagarandcompany.BeanScopes.PrototypeIntoSingletonProblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.inject.Provider;

public class UserService {
    private String name;
    private String email;
    private Integer age;
    @Autowired
    private ApplicationContext context;

//    @Autowired
//    private Provider<Address> provider;

    public Address getAddress() {
        Address address = (Address) context.getBean("address");
        return address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("calling setter");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address=" + getAddress() +
                '}';
    }
}
