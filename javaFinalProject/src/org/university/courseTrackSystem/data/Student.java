package org.university.courseTrackSystem.data;

public class Student extends Person{

    private int age;

    public Student(String name, int age){
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
