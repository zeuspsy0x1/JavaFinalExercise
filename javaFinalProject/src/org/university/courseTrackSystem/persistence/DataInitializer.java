package org.university.courseTrackSystem.persistence;
import org.university.courseTrackSystem.data.Course;
import org.university.courseTrackSystem.data.Student;
import org.university.courseTrackSystem.data.Teacher;
import org.university.courseTrackSystem.data.University;
import java.util.ArrayList;

public class DataInitializer {

    private University university;
    public DataInitializer(University university){
        this.university = university;
    }
    //Students Initialization
    private Student newStudent1 = new Student("Camilo", 12);
    private Student newStudent2 = new Student("Laura", 13);
    private Student newStudent3 = new Student("Camille", 14);
    private Student newStudent4 = new Student("Daniel", 15);
    private Student newStudent7 = new Student("Felipe", 6);
    private Student newStudent8 = new Student("Danielle", 9);
    private Student newStudent5 = new Student("Lena", 17);
    private Student newStudent6 = new Student("Yua", 16);
    private Student newStudent9 = new Student("Ichika", 19);
    private Student newStudent10 = new Student("Lala", 20);

    public void setStudents(){
        university.setStudent(newStudent1);
        university.setStudent(newStudent2);
        university.setStudent(newStudent3);
        university.setStudent(newStudent4);
        university.setStudent(newStudent5);
        university.setStudent(newStudent6);
        university.setStudent(newStudent7);
        university.setStudent(newStudent8);
        university.setStudent(newStudent9);
        university.setStudent(newStudent10);
    }


    //Teachers Initialization

    private Teacher newTeacher1 = new Teacher("Monica Trujillo", "full-time", 2, 25);
    private Teacher newTeacher2 = new Teacher("Enrique Chaux", "part-time", 5, 25);
    private Teacher newTeacher3 = new Teacher("Camilo Arias", "part-time", 2, 25);
    private Teacher newTeacher4 = new Teacher("Fernando Cardenas", "full-time", 3, 25);


    public void setLotsOfTeachers() {
        university.setTeacher(newTeacher1);
        university.setTeacher(newTeacher2);
        university.setTeacher(newTeacher3);
        university.setTeacher(newTeacher4);
    }

    // Courses Initialization

    private ArrayList<Student> listOfInitialStudentsInTheCourses1 = new ArrayList<Student>();
    {
        listOfInitialStudentsInTheCourses1.add(newStudent1);
        listOfInitialStudentsInTheCourses1.add(newStudent2);
        listOfInitialStudentsInTheCourses1.add(newStudent3);
        listOfInitialStudentsInTheCourses1.add(newStudent4);
        listOfInitialStudentsInTheCourses1.add(newStudent5);
    };
    private ArrayList<Student> listOfInitialStudentsInTheCourses2 = new ArrayList<Student>();
    {
        listOfInitialStudentsInTheCourses2.add(newStudent6);
        listOfInitialStudentsInTheCourses2.add(newStudent7);
        listOfInitialStudentsInTheCourses2.add(newStudent8);
        listOfInitialStudentsInTheCourses2.add(newStudent9);
        listOfInitialStudentsInTheCourses2.add(newStudent10);
    };
    private ArrayList<Student> listOfInitialStudentsInTheCourses3 = new ArrayList<Student>();
    {
        listOfInitialStudentsInTheCourses3.add(newStudent1);
        listOfInitialStudentsInTheCourses3.add(newStudent3);
        listOfInitialStudentsInTheCourses3.add(newStudent5);
        listOfInitialStudentsInTheCourses3.add(newStudent7);
        listOfInitialStudentsInTheCourses3.add(newStudent9);
    };
    private ArrayList<Student> listOfInitialStudentsInTheCourses4 = new ArrayList<Student>();
    {
        listOfInitialStudentsInTheCourses4.add(newStudent2);
        listOfInitialStudentsInTheCourses4.add(newStudent4);
        listOfInitialStudentsInTheCourses4.add(newStudent6);
        listOfInitialStudentsInTheCourses4.add(newStudent8);
        listOfInitialStudentsInTheCourses4.add(newStudent10);
    };


    private Course newCourse1 = new Course("Programming", "C-1", "Enrique Chaux", listOfInitialStudentsInTheCourses1);
    private Course newCourse2 = new Course("Math", "C-3", "Camilo Arias", listOfInitialStudentsInTheCourses2);
    private Course newCourse3 = new Course("Research", "C-6", "Fernando Cardenas", listOfInitialStudentsInTheCourses3);
    private Course newCourse4 = new Course("Social Psychology (Experimental) ", "C-9", "Monica Trujillo", listOfInitialStudentsInTheCourses4);


    public void setLotsOfCourses() {
        university.setCourse(newCourse1);
        university.setCourse(newCourse2);
        university.setCourse(newCourse3);
        university.setCourse(newCourse4);
    }
}
