package com.suresh.week1Intro.basic_intro;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.env", havingValue = "development")
public class DevDB implements DB {
    @Override
    public String getDB() {
        return "DEV DB";
    }
}
