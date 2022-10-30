package org.university.courseTrackSystem.data;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private String assignedClassroom;
    private ArrayList<Student> listOfStudentsInTheCourse;
    private String teacher;

    public Course(String courseName, String assignedClassroom, String teacher, ArrayList<Student> listOfStudentsInTheCourse) {
        this.courseName = courseName;
        this.assignedClassroom = assignedClassroom;
        this.teacher = teacher;
        this.listOfStudentsInTheCourse = listOfStudentsInTheCourse;
    }

    //getters


    public String getCourseName() {
        return this.courseName;
    }

    public String getAssignedClassroom() {
        return this.assignedClassroom;
    }

    public String getTeacher() {
        return this.teacher;
    }
    public ArrayList<Student> getListOfStudentsInTheCourse(){
        return this.listOfStudentsInTheCourse;
    }
    public String  getNameOfStudentsInTheCourse(int index){
        return this.listOfStudentsInTheCourse.get(index).getName();
    }
    //setters


    public void setOneStudentInTheCourse(Student newStudent) {
        this.listOfStudentsInTheCourse.add(newStudent);
    }
}


