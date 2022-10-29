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
        dataInitializer.setLotsOfStudents();
//        dataInitializer.setLotsOfTeachers();
//        dataInitializer.setLotsOfCourses();



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
//                case 2:
//                    //logInToTheUserAccount(bank);
//                    break;
//                case 3:
//                    //printAllUsersInformation(bank);
//                    break;
//                case 4:
//                    //printAllUsersInformation();
//                    break;
//                case 3:
//                    //printAllUsersInformation(bank);
//                    break;
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


    //Case 3
    private void createStudentAndAddThemToAClass(){

    }


}
