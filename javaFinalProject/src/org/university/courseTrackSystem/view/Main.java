package org.university.courseTrackSystem.view;
import org.university.courseTrackSystem.data.*;
import org.university.courseTrackSystem.persistence.DataInitializer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = new University("Los Andes University");
//        System.out.println("Welcome to University!");
        DataInitializer dataInitializer = new DataInitializer(university);
            dataInitializer.setStudents();
            dataInitializer.setLotsOfTeachers();
            dataInitializer.setLotsOfCourses();

        int option;


        do {
            System.out.println("Pick an option:");
            System.out.println("1. Print all the teachers data.");
            System.out.println("2. Print all the courses.");
            System.out.println("3. Create a new student and add it to an existing course.");
            System.out.println("4. Create a new course with teacher, students and more information.");
            System.out.println("5. List all the courses of a single student.");

            Scanner myScanner = new Scanner(System.in);
            option = myScanner.nextInt();
            myScanner.reset();

            switch (option){
                case 1:
                    listAllTeachers(university);
                    break;
                case 2:
                    printAllCoursesAndShowMenuToPrintCourseDetails(university);
                    break;
                case 3:
                    createStudentAndAddThemToAnExistentClass(university);
                    break;
//                case 4:
//                    //printAllUsersInformation();
//                    break;
                case 5:
                    printAllCoursesOfAStudent(university);
                    break;
                default:
                    System.out.println("Select a correct number.");
                    break;
            }
        } while ( option != 9 );

    }
//Case 1
    private static void listAllTeachers(University university) {
        for (int i = 0; i < university.getListOfTeachersToPrint().size(); i++) {
            System.out.println(university.getListOfTeachersToPrint().get(i));
        }
    }
//Case 2

    private static void printAllCoursesAndShowMenuToPrintCourseDetails(University university) {
        ArrayList<String> allCourses;
        allCourses = university.returnAllCourses();
        for (int i = 0; i < allCourses.size(); i++) {
            System.out.println(i + " " + allCourses.get(i));
        }

        Scanner myScanner = new Scanner(System.in);
        int coursesMenuOption = myScanner.nextInt();
        myScanner.reset();

        Course courseSelected = university.getCourseByItsIndexInTheList(coursesMenuOption);

        System.out.println("Name " + courseSelected.getCourseName() + "Classroom " + courseSelected.getAssignedClassroom()
                + "Teacher " + courseSelected.getTeacher());

        ArrayList<String> students = new ArrayList<String>();

        for (int z = 0; z < courseSelected.getListOfStudentsInTheCourse().size(); z++) {
            students.add(courseSelected.getNameOfStudentsInTheCourse(z));
        }

        for (int x = 0; x < students.size(); x++) {
            System.out.println(students.get(x));
        }
    }
    //Case 3

        private static void createStudentAndAddThemToAnExistentClass(University university){
            Scanner myScanner = new Scanner(System.in);

            System.out.println("Write the name of the student: ");
            String studentName = myScanner.next();
            myScanner.reset();

            System.out.println("Write the age of the student: ");
            int studentAge = myScanner.nextInt();
            myScanner.reset();

            System.out.println("Take a look at the list and write the name of the course the student needs: ");

            ArrayList<String> allCourses;
            allCourses = university.returnAllCourses();
            for (int i = 0; i < allCourses.size(); i++) {
                System.out.println(i + " " + allCourses.get(i));
            }
            int courseInt = myScanner.nextInt();
            myScanner.reset();
            String courseName;
            courseName = university.getCourseByItsIndexInTheList(courseInt).getCourseName();

            String result = university.createStudentAndAddThemToAClass(studentName, studentAge, courseName);

            System.out.println(result);
        }


        //Case 4

        private static void printAllCoursesOfAStudent (University university){
            Scanner myScanner = new Scanner(System.in);

            ArrayList<Student> students;
            ArrayList<String> courses;
            students = university.getListOfStudents();

            for (int i = 0; i < students.size(); i++) {
                System.out.println(i + " " + students.get(i).getName());
            }
            System.out.println("Enter the student number from this list to see their courses:");
            int studentInt = myScanner.nextInt();
            myScanner.reset();

            Student student = students.get(studentInt);

            courses = university.getStudentListOfCourses(student);

            for (int i = 0; i < courses.size(); i++) {
                System.out.println(courses.get(i));
            }

        }

}
