package com.suresh.week1.alice_bakery.strawberry;

import com.suresh.week1.alice_bakery.interfaces.Frosting;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "frosting", havingValue = "strawberry")
public class StrawberryFrosting implements Frosting {
    @Override
    public String getFrostingType() {
        return "Strawberry Frosting";
    }
}
