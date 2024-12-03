package com.suresh.week1Intro;

import com.suresh.week1Intro.week_1.CakeBaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroductionToSpringBootApplication implements CommandLineRunner {

//	@Autowired
//	Apple apple1;
//
//	@Autowired
//	Apple apple2;

//	@Autowired
//	DBService dbService;

    @Autowired
	CakeBaker cakeBaker;

    public static void main(String[] args) {
        SpringApplication.run(IntroductionToSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		apple1.eatApple();
//		apple2.eatApple();
//
//		System.out.println("Apple 1 Hashcode --> "+apple1.hashCode());
//		System.out.println("Apple 2 Hashcode --> "+apple2.hashCode());
//
//		System.out.println("Which DB Running --> "+dbService.getData());

		System.out.println("CakeBaker  --> "+cakeBaker.bakeCake());

    }
}
