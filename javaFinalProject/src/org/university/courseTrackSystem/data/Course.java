package org.university.courseTrackSystem.data;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private String assignedClassroom;
    private String teacherName;
    private ArrayList<Student> listOfStudentsInTheCourse;


    public Course(String courseName, String assignedClassroom, String teacherName, ArrayList<Student> listOfStudentsInTheCourse) {
        this.courseName = courseName;
        this.assignedClassroom = assignedClassroom;
        this.teacherName = teacherName;
        this.listOfStudentsInTheCourse = listOfStudentsInTheCourse;
    }

    //getters
    public String getCourseName() {
        return this.courseName;
    }

    public String getAssignedClassroom() {
        return this.assignedClassroom;
    }

    public String getTeacherName() {
        return this.teacherName;
    }
    public ArrayList<Student> getListOfStudentsInTheCourse(){
        return this.listOfStudentsInTheCourse;
    }
    public String  getNameOfStudentsInTheCourse(int index){
        return this.listOfStudentsInTheCourse.get(index).getName();
    }


    //setters
    public void addOneStudentToTheCourse(Student newStudent) {
        this.listOfStudentsInTheCourse.add(newStudent);
    }

}


