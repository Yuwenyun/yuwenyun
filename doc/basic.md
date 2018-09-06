1. spring boot setup
```
-- add dependency
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.1.RELEASE</version>
    <relativePath />
</parent>
...
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

-- add rest controller
@RestController
public class SimpleController {

    @RequestMapping("/")
    public String homePage()
    {
        return "home";
    }
}

-- start the application
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
```
note:
- @RestController: tells Spring to render the resulting string directly back to the caller
- @RequestMapping: tells Spring that any HTTP request with the / path should be mapped to the homePage() method
- @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan

To create an executable jar, we need to add the spring-boot-maven-plugin to our pom.xml
```
<plugins>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
</plugins>
```

2. if not want to inherit from spring boot, import all the dependencies explicitly
```
<dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>2.0.4.RELEASE</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
</dependencyManagement>
```

3. starters
- Starters are a set of convenient dependency descriptors that you can include in your application
- All official starters follow a similar naming pattern; spring-boot-starter-*, where * is a particular type of application
```
spring-boot-starter-log4j2
spring-boot-starter-activemq
...
```
4. structuring code.
- Main class shall be located at the root package above all the other classes.
- @Import annotation can be used to import other @Configuration classes, @ImportResource annotation can be used to import other xml configurations

5. Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies that you have added.
- enable auto-configuration with @EnableAutoConfiguration annotation
- exclude specific configuration with @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
- add **--debug** as console args to enable logging details of auto-configuration

6. @ComponentScan will enable scanning @Component, @Service, @Repository, @Controller

7. devtools
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```
- spring-boot-devtools disables the caching options by default.
- automatically restart whenever files on the classpath change(depends on IDE, file change triggers restart in Eclipse while rebuild in IDEA)
- DevTools relies on the application context’s shutdown hook to close it during a restart. It **does not work** correctly if you have disabled the shutdown hook (**SpringApplication.setRegisterShutdownHook(false)**)

8. properties
- define properties in application.properties for the whole application to use
- using @Value annotation to access the property
- to generate random number
```
my.secret=${random.value}
my.number=${random.int}
my.bignumber=${random.long}
my.uuid=${random.uuid}
my.number.less.than.ten=${random.int(10)}
my.number.in.range=${random.int[1024,65536]}
```
- command line args(start with **--**) take precedence over other property source and will be added to spring properties context
- profile specific properties can be in application-${profile}.properties and activate the profile in application.properties **spring.profiles.active=dev**
- properties in application.properties are filtered through existing properties when used, enabling placeholder
```
app.name=MyApp
app.description=${app.name} is a spring boot application
```
9. @Profile("dev") works with @Component and @Configuration


