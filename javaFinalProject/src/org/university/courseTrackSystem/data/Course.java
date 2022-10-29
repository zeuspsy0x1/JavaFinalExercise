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
}


