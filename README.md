# BeanScopes
https://www.sagarandcompany.com/
# How to define Scope of Bean in Spring?
There are 4 types of scope

Singleton: one bean for per class loader (by default scope of bean)

Prototype: when you are requesting to get bean

request: you will get new bean as new HttpRequest

session: you will get new bean as new http session

To define scope of bean in xml we have scope attribute of bean tag. like

```xml
<bean name="address" class="com.sagarandcompany.BeanScopes.PrototypeIntoSingletonProblem.Address" scope="prototype">
        <property name="city" value="High Tech City"/>
        <property name="district" value="banglore"/>
    </bean>
```

# Annotation to define scope?

@Scope("request");

@Scope("session");

@Scope("prototype");

@New Annotation to define scope we have like this

@RrequestScope

@SessionScope

@PrototypeScope

![alt text](http://res.cloudinary.com/sagarandcompany/image/upload/v1514262023/singleton_nobizl.png)

# Spring - Injecting a Prototype Bean into a Singleton Bean Problem

If same scoped beans are wired together there's no problem. For example a singleton bean A injected into another singleton bean B. But if the bean A has the narrower scope say prototype scope then there's a problem.

To understand the problem let's see an example. We are going to have two beans MyPrototypeBean, scoped as prototype and MySingletonBean, scoped as singleton. We will inject the prototype bean into the singleton bean. We will also access MySingletonBean via method call context#getBean(MySingletonBean.class) multiple times. We are expecting (per prototype specifications) that a new prototype bean will be created and be injected into MySingletonBean every time.

That means there's only one instance of the prototype bean within the singleton bean. Well, a prototype bean should not behave that way. There should be a new instance every time.

The problem is: spring container only creates the singleton bean MySingletonBean once, and thus only gets one opportunity to inject the dependencies into it. The container cannot provide MySingletonBean with a new instance of  MyPrototypeBean every time one is needed.

To solve this problem i autowired the applicaion context in singelton bean and get bean of protoyoe type into singleton
You can also do using provider...
here is the way to get bean from provider....
```java

public class UserService {
    private String name;
    private String email;
    private Integer age;
    @Autowired
    private Provider<Address> provider;


    public Address getAddress() {
        Address address = provider.get();
        return address;
    }
}

```

here is the way to get bean from application context....


```java
public class UserService {
    private String name;
    private String email;
    private Integer age;
    @Autowired
    private ApplicationContext context;


    public Address getAddress() {
        Address address = (Address) context.getBean("address");
        return address;
    }
}
```

