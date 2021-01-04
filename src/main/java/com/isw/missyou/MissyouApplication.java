package com.isw.missyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MissyouApplication {
  public static void main(String[] args) {
    SpringApplication.run(MissyouApplication.class, args);
  }
}

// 在面向对象中变化的应对方案 在springboot中要时时刻刻提醒自己如何面对变化
// 1. 指定一个interface， 然后用多个类实现同一个interface， 这就是策略模式
// 2. 只有一个类， 属性的变化来应对变化， 这个时候就可以用配置文件在改变属性的值， 就好像property.yaml。 变化是不可避免的， 不过我们要做的事情是将变化隔离
// 3. 一个interface 只被一个类实现的时候也要写接口， 这样增加代码的灵活性，为了将来好扩张， 这称为防御性编程。总之核心思想就是面向抽象和接口编程

// springboot 的核心优势是自动配置， 一定要理解什么是自动配置 类比其他web框架
// OCP -> IOC 首先有一个容器, 然后把依赖灵活地加入到容器, 然后注入依赖。
// 目的：
// 抽象意义就是把控制权交给用户
// springboot是为了实现灵活的OCP 因为框架要满足各种各样的需求和场景，所以灵活性是很重要的， 然后springboot的自动装配帮助我们提高了把依赖灵活的加入容器

// 以下都是最基本的注解， 其核心功能就是实例化Java类 模式注解
// @Component  组件、类、 java bean在注解里面没有什么区别

// @RestController @Controller
// @Service
// @Repository

// @Configuration 这个注解可以将多个bean灵活的同时地加入到IOC容器里面 其他注解只能加入一个bean

// @Configuration 可以增加我们对代码的控制权， 我们可以进行一系列操作以后再将实例加入到IOC容器里面
// @Configuration + @Bean 是一种编程模式， 让我们可以将程序的变化变成改写配置文件。进而实现OCP原则

// 在springboot应用启动的时候IOC容器就将实例化我们的bean并且将其注入， 这个是默认的机制， 但是我们可以改变这个默认机制，比如在一个java类上加上@Lazy 注解
// 可有延迟某个类的实例化

// 策略模式的变化方案： 1. byName 切换bean name 2. @Qualifier 指定bean 3. 有选择的只注入一个bean。 4.@Primary
// 条件注解 @Conditional

// springboot 的自动装配，自动帮你配置，引入第三方库或者SDK springboot的主入口类实际上是一个很大的configuration配置类

// SPI service provider interface 的思想和机制
// 基于interface + 策略模式 + 配置文件
// @Primary or @Conditional 解决的是类或者对象的变化问题， 很具体，粒度小
// SPI 解决的整体方案的变化 很抽象

// springboot的自动装配真正解决的问题是他有独特的IOC容器， 那么自动装配帮助springboot自动发现各种java bean，然后加入到IOC容器里面去
// 整个深度理论课讲解了那么多的东西，所有的一切都是为了实现OCP原则而服务，从而应对系统里的各种变化，编写出可维护的代码，这是我们用java的根本原因，也是为什么有人觉得java笨重庞大的原因
// 以上就是springboot的核心机制
// 下面开始springboot的框架机制, 我们一般要对框架进行二次封装，对于我们使用的框架进行加强，首先就要对异常处理机制进行加强

// 异常反馈给前端， unify response
// 异常的分类 Throwable 是所有Exception和Error的基类， Error 我们是代码不能控制处理的，所以最后在java中我们就要处理exception 异常
// Exception 也分为 checked exception 和 Runtime Exception

// checked exception 是我们能够处理的bug 如果不处理在编译阶段就会出问题。 我们在一个函数中 throws Exception 本质上也是处理了异常，如果我们是java
// web项目，
// 我们一般会有一个全局的异常处理机制在处理所有的异常， 所以我们一般会用 runtime exception 或者又叫做unchecked exception.
// 一般我们Java程序员处理不了runtime
// exception, 我们会将这个异常返回给前端， 异常不一定是bug， 但是基本上checked exception 就是bug

// 已知异常和未知异常

// 对于未知异常，对于前端开发者和用户没有任何意义，所以我们要模糊的处理未知异常1

// springboot 的自动发现机制，通过对于类的各种不同的注解，然后springboot就知道你这个类是干什么，然后帮助程序员自动注册，这样有利于AOP

// 参数校验： 在springboot中如何从前端接受不同的数据或者参数
// 1， 从URL中接受参数有两种情况：第一种情况：/v1/banner/test/2 @PathVariable， 第二种情况：/v1/banner/test/2?name=manu

// java应用分层的的意义：
// 在微服务之前，在大型项目上分成的意义是为了让不同的团队工作在不同的层上进行分工，这厮一种水平分隔，在微服务里分层是垂直分隔。
// 分层本质上也是为了实现OCP，

// 在理论上java中层与层之间是要求用interface来进行连接的，但是在实际项目中如果你的需求变化不大，那么也不似说必须用interface来连接
// 一切都要根据你的实际项目需求来决定

// 部署springboot的应用，利用maven可以生成uber jar 包 里面内置了tomcat服务器，直接利用java -jar missyou.jar
// --spring.profiles.active=dev
//

// 数据库的设计步骤和数据库优化原则
// 数据库里面类与类之间的关系：
// 1. 1对1的关系，比如人和身份证的关系。理论上来讲，数据库里面的1对1的关系本来是可以不用存在的，你可以把所有的字段写在一张表里面，比如你可以把身份证里面的
// 所有内容都写在人这个表里面，但是为了查询效率和业务的角度，你可以分成两个表来考虑
// 2. 1对多的关系， 比如班级和学生， 这个关系是最容易理解的 不用多说
// 3. 多对多的关系，比如老师和学生的关系就是典型的多对多的关系。这个多对多的关系最难理解并且最复杂的，多对多的关系一般有三张表来表示，并且第三张表可能有意义
// 可能无意义，要看具体的业务逻辑 teacher_id, student_id, teacher_student_id, 有可能就是第三张表的内容，此时第三张表就是无意义的表，但是优惠券和
// 使用人的关系也是多对多的关系，但是表示他们关系的第三张表就是好有意义的表，除了那三个id字段以外，还有优惠券的状态就应该存在第三张表里面。表的设计是整个
// 应用中非常重要的一部分，必须牢牢掌握。

// database design and performance
// step 1: class，model(entity) -> table
// step 2: the relationship between classes
// step 3: 细化： 字段，长度，类型，限制，小数点，唯一索引等。
// performance aspect for database design:
// horizontal split: 10M rows becomes 2M rows with 5 tables
// vertical split: if a table has more than 100 fields, then we can split this table into 2 tables with one on one relationship
// 数据库设计只能在很小的程度上决定数据库的效率，数据库的查询方式才是决定数据库效率的关键因素。随着现在技术的发展，尽量的多使用缓存技术，少对于数据库进行
// 直接访问是最佳的提高数据库效率的方法，而且一旦数据库设计好了 尽量的少去动数据库，因为数据库是很底层的东西了，一旦动了数据库，有可能很多代码都是需要修改
// 项目开发的顺序：一般来说先开发CMS，然后再开发前端。对于前后端的项目来说，应该先开发服务器提供数据，然后再开发前端
