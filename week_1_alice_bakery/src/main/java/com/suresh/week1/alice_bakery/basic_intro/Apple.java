package com.suresh.week1.alice_bakery.basic_intro;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


//@Component
public class Apple {

    void eatApple(){
        System.out.println("Eating apple");
    }

    //Initialization work
    @PostConstruct
    void appleBeanInit(){
        System.out.println("appleBeanInit");
    }

    //Destroy work
    @PreDestroy
    void appleBeanDestroyed(){
        System.out.println("destroying appleBean");
    }
}
