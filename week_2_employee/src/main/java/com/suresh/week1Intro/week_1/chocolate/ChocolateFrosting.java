package com.suresh.week1Intro.week_1.chocolate;

import com.suresh.week1Intro.week_1.interfaces.Frosting;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "frosting", havingValue = "chocolate")
public class ChocolateFrosting implements Frosting {

    @Override
    public String getFrostingType() {
        return "Chocolate Frosting";
    }
}
