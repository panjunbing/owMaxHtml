package com.owmax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by panpan on 2017/4/18    ^_^
 */

@SpringBootApplication
@EnableAutoConfiguration
@ImportResource("applicationContext.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
