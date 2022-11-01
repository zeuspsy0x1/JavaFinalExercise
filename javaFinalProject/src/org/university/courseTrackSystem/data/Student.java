package org.university.courseTrackSystem.data;

public class Student extends Person{

    private int age;
    /***
     * Creates a new student with its name, age and id.
     * @param name of the student, it's a String, and it needs at least 1 letter to be valid.
     * @param age of the student, it's an int, and it's valid if it is between 1 and 120.
     */
    public Student(String name, int age){
        super(name);
        this.age = age;
    }
}
