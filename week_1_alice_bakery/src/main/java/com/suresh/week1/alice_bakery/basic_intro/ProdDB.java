package com.suresh.week1.alice_bakery.basic_intro;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.env", havingValue = "production")
public class ProdDB implements DB {
    @Override
    public String getDB() {
        return "Prod DB";
    }
}
