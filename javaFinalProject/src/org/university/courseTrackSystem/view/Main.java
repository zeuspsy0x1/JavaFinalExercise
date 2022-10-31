package org.university.courseTrackSystem.view;
import org.university.courseTrackSystem.data.*;
import org.university.courseTrackSystem.persistence.DataInitializer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = new University("The University");
        System.out.println("Welcome to The University!");

        DataInitializer dataInitializer = new DataInitializer(university);
            dataInitializer.setStudents();
            dataInitializer.setLotsOfTeachers();
            dataInitializer.setLotsOfCourses();

        int option;

        do {
            System.out.println("Select an option:");
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
                case 4:
                    createClassAndAddRelevantDataToIt(university);
                    break;
                case 5:
                    printAllCoursesOfAStudent(university);
                    break;
                default:
                    System.out.println("Select a correct number.");
                    break;
            }
        } while ( option != 6 );

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
                + "Teacher " + courseSelected.getTeacherName());

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

        private static void createClassAndAddRelevantDataToIt (University university){
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Write the name of the new course: ");
            String courseName = myScanner.next();
            myScanner.reset();

            System.out.println("Write the name of the classroom: ");
            String classroom = myScanner.next();
            myScanner.reset();

            System.out.println("Write the number of the teacher for this course: ");

            for (int i = 0; i < university.getListOfTeachersToPrint().size(); i++) {
                System.out.println(i + " " + university.getListOfTeachersToPrint().get(i));
            }
            int courseTeacherIndex = myScanner.nextInt();
            myScanner.reset();

            Teacher teacher = university.getListOfTeachers().get(courseTeacherIndex);

            ArrayList<Student> students;
            students = university.getListOfStudents();

            for (int i = 0; i < students.size(); i++) {
                System.out.println(i + " " + students.get(i).getName());
            }
            students = selectedStudentsForTheNewCourse(university, students.size());

            String createdOrNot = university.createCourseWithNewAndExistentData(courseName, classroom, teacher.getName(), students);
            if (Objects.equals(createdOrNot, "Course successfully created.")){
                System.out.println("Course successfully created.");
            }
        }

        //Case 5
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

        private static ArrayList<Student> selectedStudentsForTheNewCourse(University university, int studentsSize){

            Scanner myScanner = new Scanner(System.in);

            ArrayList<Integer> listOfStudentIndexes = new ArrayList<Integer>();
            int option = 1;
            myScanner.reset();

            do {
                switch (option){
                    case 1:
                        System.out.println("Select the students by their numbers from the previous list, " +
                                "add the student numbers one by one... Or send 999 to stop adding students.");
                        int studentInt = myScanner.nextInt();
                        myScanner.reset();

                        if (studentInt == 999 || studentInt <= 0) {
                            option = 3;
                            break;
                        }
                        if ( studentInt <= studentsSize - 1){
                            listOfStudentIndexes.add(studentInt);
                            System.out.println("Student " + studentInt + " added to the course.");
                        } else {
                            System.out.println("Student doesn't exist.");
                        }
                        break;
                    case 2:
                        option = 999;
                        break;
                    default:
                        System.out.println("Send a correct number.");
                        option = 1;
                        break;
                }
            } while (option <= 2);

            ArrayList<Student> students = new ArrayList<Student>();

                for (int i = 0; i < listOfStudentIndexes.size(); i++) {
                    students.add(university.getStudentByIndex(listOfStudentIndexes.get(i)));
                }

            return students;
}}
