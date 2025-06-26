package com.practice.week1.day7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private final Engine engine;
    private Tyre tyre;

    @Autowired
    public Vehicle(Engine engine){
        this.engine = engine;
    }

    @Autowired
    public void setTyre(Tyre tyre){
        this.tyre = tyre;
    }

    public void move(){
        engine.start();
        tyre.rotate();
        System.out.println("Vehicle is moving...");
    }
}
