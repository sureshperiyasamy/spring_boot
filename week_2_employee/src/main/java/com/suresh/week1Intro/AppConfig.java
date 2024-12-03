package com.suresh.week1Intro;


import com.suresh.week1Intro.basic_intro.Apple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {


    @Bean
    @Scope("singleton")
    Apple getApple() {
        return new Apple();

    }
}
