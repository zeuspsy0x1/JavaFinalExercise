package org.university.courseTrackSystem.data;

import static java.lang.Math.random;

public class Person {

    private String name;
    private final double id;

    public Person(String name){
        this.name = name;
        this.id = random();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getId() {
        return this.id;
    }
}
