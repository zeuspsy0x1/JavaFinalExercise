package org.university.courseTrackSystem.data;

public class Student extends Person{

    private int age;

    public Student(String name, int age){
        super(name);
        this.age = age;
    }
}
