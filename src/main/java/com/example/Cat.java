package com.example;

import java.util.List;

public class Cat implements Predator {

    private Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }

    public String getSound() {
        return "Мяу";
    }

    public List<String> eatMeat() throws Exception {
        return eatMeat();
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
