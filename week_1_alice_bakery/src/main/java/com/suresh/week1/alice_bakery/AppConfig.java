package com.suresh.week1;


import com.suresh.week1.alice_bakery.basic_intro.Apple;
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
