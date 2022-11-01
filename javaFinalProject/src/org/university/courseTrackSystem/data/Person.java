package org.university.courseTrackSystem.data;

import static java.lang.Math.random;


public class Person {

    private String name;
    private final double id;

    /***
     * Creates a new Person with its name and id. It has 2 children (Student and Teacher).
      * @param name of the person, it's a String, and it needs at least 1 letter to be valid.
     */
    public Person(String name){
        this.name = name;
        this.id = random();
    }

    public String getName() {
        return this.name;
    }

    public double getId() {
        return this.id;
    }

}
