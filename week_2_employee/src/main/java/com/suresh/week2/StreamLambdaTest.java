package com.suresh.week2;

import java.util.stream.Stream;

public class StreamLambdaTest {

    public static void main(String[] args) {

//        Walkable walkable = new Walk();
//        walkable.walk(4, true);

//        Walkable walkable = (int steps, boolean isEnabled) -> {
//            System.out.println("Walk step "+steps);
//            return 0;
//        };
//        walkable.walk(4, true);

//        Walkable walkable = (steps, isEnabled) ->  steps;
//        walkable.walk(4, true);

//        Stream

    }
}


interface Walkable {
    int walk(int steps, boolean isEnabled);
}


class Walk implements Walkable {


    @Override
    public int walk(int steps, boolean isEnabled) {
        System.out.println("Walk step "+steps);
        return 0;
    }

}

