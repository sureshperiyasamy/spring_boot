package com.suresh.week1Intro.week_1;

import com.suresh.week1Intro.week_1.interfaces.Frosting;
import com.suresh.week1Intro.week_1.interfaces.Syrup;
import org.springframework.stereotype.Service;

@Service
public class CakeBaker {

    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public String bakeCake() {

        return "Cake with " + frosting.getFrostingType() + " and " + syrup.getSyrupType();

    }
}
