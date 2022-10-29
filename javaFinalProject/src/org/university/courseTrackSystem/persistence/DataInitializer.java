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

    private ArrayList<Student> listOfInitialStudents = new ArrayList<Student>(){{
        listOfInitialStudents.add(newStudent1);
        listOfInitialStudents.add(newStudent2);
        listOfInitialStudents.add(newStudent3);
        listOfInitialStudents.add(newStudent4);
        listOfInitialStudents.add(newStudent5);
        listOfInitialStudents.add(newStudent6);
        listOfInitialStudents.add(newStudent7);
        listOfInitialStudents.add(newStudent8);
        listOfInitialStudents.add(newStudent9);
        listOfInitialStudents.add(newStudent10);
    }};
    public void setLotsOfStudents() {
        for (int i = 0; i < listOfInitialStudents.size(); i++) {
            university.setStudent(listOfInitialStudents.get(i));
        }
    }
//
//    //Teachers Initialization
//
//    private Teacher newTeacher1 = new Teacher("Monica Trujillo", "full-time", 9, 25);
//    private Teacher newTeacher2 = new Teacher("Enrique Chaux", "part-time", 10, 25);
//    private Teacher newTeacher3 = new Teacher("Camilo Arias", "part-time", 4, 25);
//    private Teacher newTeacher4 = new Teacher("Fernando Cardenas", "full-time", 13, 25);
//
//    private ArrayList<Teacher> listOfInitialTeachers = new ArrayList<Teacher>(){{
//        listOfInitialTeachers.add(newTeacher1);
//        listOfInitialTeachers.add(newTeacher2);
//        listOfInitialTeachers.add(newTeacher3);
//        listOfInitialTeachers.add(newTeacher4);
//        }};
//
//    public void setLotsOfTeachers() {
//        for (int i = 0; i < listOfInitialTeachers.size(); i++) {
//            university.setTeacher(listOfInitialTeachers.get(i));
//        }
//    }
//
//    // Courses Initialization
//
//    private ArrayList<Student> listOfInitialStudentsInTheCourses1 = new ArrayList<Student>(){{
//        listOfInitialStudents.add(newStudent1);
//        listOfInitialStudents.add(newStudent2);
//        listOfInitialStudents.add(newStudent3);
//        listOfInitialStudents.add(newStudent4);
//        listOfInitialStudents.add(newStudent5);
//    }};
//    private ArrayList<Student> listOfInitialStudentsInTheCourses2 = new ArrayList<Student>(){{
//
//        listOfInitialStudents.add(newStudent6);
//        listOfInitialStudents.add(newStudent7);
//        listOfInitialStudents.add(newStudent8);
//        listOfInitialStudents.add(newStudent9);
//        listOfInitialStudents.add(newStudent10);
//    }};
//    private ArrayList<Student> listOfInitialStudentsInTheCourses3 = new ArrayList<Student>(){{
//        listOfInitialStudents.add(newStudent1);
//        listOfInitialStudents.add(newStudent3);
//        listOfInitialStudents.add(newStudent5);
//        listOfInitialStudents.add(newStudent7);
//        listOfInitialStudents.add(newStudent9);
//    }};
//    private ArrayList<Student> listOfInitialStudentsInTheCourses4 = new ArrayList<Student>(){{
//        listOfInitialStudents.add(newStudent2);
//        listOfInitialStudents.add(newStudent4);
//        listOfInitialStudents.add(newStudent6);
//        listOfInitialStudents.add(newStudent8);
//        listOfInitialStudents.add(newStudent10);
//    }};
//
//
//    private Course newCourse1 = new Course("Programming", "C-1", "Enrique Chaux", listOfInitialStudentsInTheCourses1);
//    private Course newCourse2 = new Course("Math", "C-3", "Camilo Arias", listOfInitialStudentsInTheCourses2);
//    private Course newCourse3 = new Course("Research", "C-6", "Fernando Cardenas", listOfInitialStudentsInTheCourses3);
//    private Course newCourse4 = new Course("Social Psychology (Experimental) ", "C-9", "Monica Trujillo", listOfInitialStudentsInTheCourses4);
//
//    private ArrayList<Course> listOfInitialCourses= new ArrayList<Course>(){{
//        listOfInitialCourses.add(newCourse1);
//        listOfInitialCourses.add(newCourse2);
//        listOfInitialCourses.add(newCourse3);
//        listOfInitialCourses.add(newCourse4);
//
//    }};
//
//    public void setLotsOfCourses() {
//        for (int i = 0; i < listOfInitialCourses.size(); i++) {
//            university.setCourse(listOfInitialCourses.get(i));
//        }
//    }


}
