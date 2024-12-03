package com.suresh.week1Intro.week_1.strawberry;

import com.suresh.week1Intro.week_1.interfaces.Syrup;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "syrup", havingValue = "strawberry")
public class StrawberrySyrup implements Syrup {
    @Override
    public String getSyrupType() {
        return "StrawberrySyrup";
    }
}
