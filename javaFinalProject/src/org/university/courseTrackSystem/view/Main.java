package org.university.courseTrackSystem.view;
import org.university.courseTrackSystem.data.*;
import org.university.courseTrackSystem.persistence.DataInitializer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = new University("The University");
        System.out.println(" Welcome to The University! ");

        DataInitializer dataInitializer = new DataInitializer(university);
            dataInitializer.setStudents();
            dataInitializer.setLotsOfTeachers();
            dataInitializer.setLotsOfCourses();

        int option;

        do {
            System.out.println(" ");
            System.out.println("|||||||||||||||||||| Select an option: |||||||||||||||||||");
            System.out.println(" ");
            System.out.println("  1. Print all the teachers data.");
            System.out.println("  2. Print all the courses and its details.");
            System.out.println("  3. Create a new student and add it to an existing course.");
            System.out.println("  4. Create a new course with teacher, students and more information.");
            System.out.println("  5. List all the courses of a single student.");
            System.out.println("  6. List all the people in the university.");
            System.out.println("  7. Exit");

            Scanner myScanner = new Scanner(System.in);
            try{
                option = myScanner.nextInt();
            }catch (InputMismatchException e) {
                option = -1;
            }

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
                    createCourseAndAddRelevantDataToIt(university);
                    break;
                case 5:
                    printAllCoursesOfAStudent(university);
                    break;
                case 6:
                    listAllThePeopleOfTheUniversity(university);
                    break;
                case 7:
                    option = 8;
                    break;
                default:
                    System.out.println( "Error:" + " Select a correct number.");
                    break;
            }
        } while ( option != 8 );

    }


//Case 1
    private static void listAllTeachers(University university) {
        System.out.println("  ");
        System.out.println("These are the current teachers at the university:");
        for (int i = 0; i < university.getListOfTeachersToPrint().size(); i++) {
            System.out.println("  " + university.getListOfTeachersToPrint().get(i));
        }
        System.out.println("  ");
    }
//Case 2

    private static void printAllCoursesAndShowMenuToPrintCourseDetails(University university) {
        ArrayList<String> allCourses;
        allCourses = university.getAllCourses();
        System.out.println("  ");
        System.out.println(" These are all the available courses, select one by its number: ");
        System.out.println("  ");
        for (int i = 0; i < allCourses.size(); i++) {
            System.out.println(i + " " + allCourses.get(i));
        }

        Scanner myScanner = new Scanner(System.in);
        int coursesMenuOption;
        try{
            coursesMenuOption = myScanner.nextInt();
        } catch (InputMismatchException e){
            coursesMenuOption = -1;
        }
        myScanner.reset();

        if (coursesMenuOption <= allCourses.size() && coursesMenuOption >= 0){

        Course courseSelected = university.getCourseByItsIndexInTheList(coursesMenuOption);

        System.out.println(" This is the information about the course:");

        System.out.println("   Name: " + courseSelected.getCourseName() + "   Classroom: " + courseSelected.getAssignedClassroom()
                + "   Teacher: " + courseSelected.getTeacherName());

        ArrayList<String> students = new ArrayList<String>();

        for (int z = 0; z < courseSelected.getListOfStudentsInTheCourse().size(); z++) {
            students.add(courseSelected.getNameOfStudentsInTheCourse(z));
        }
        System.out.println(" These are all the students in the course:");
        for (int x = 0; x < students.size(); x++) {
            System.out.println("  - " + students.get(x));
        }
        }else{
            System.out.println(" Enter a valid course number next time.");
        }}
    //Case 3

        private static void createStudentAndAddThemToAnExistentClass(University university){
            Scanner myScanner = new Scanner(System.in);

            System.out.println("Write the name of the student: ");
            String studentName = myScanner.next();
            myScanner.reset();

            if (studentName.matches(".*[a-z].*")){

                System.out.println("Write the age of the student: ");

                int studentAge = 999;

                try{
                    studentAge = myScanner.nextInt();
                }catch (InputMismatchException e){
                    System.out.println(" The student's age is invalid. ");
                }

                myScanner.reset();

                if (studentAge > 0 && studentAge <= 120){
                    System.out.println("Write the number of the course that the student needs to be in: ");
                    System.out.println("  ");
                    ArrayList<String> allCourses;
                    allCourses = university.getAllCourses();
                    for (int i = 0; i < allCourses.size(); i++) {
                        System.out.println(i + " " + allCourses.get(i));
                    }
                    int courseInt = 999;
                    try {
                        courseInt = myScanner.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Select a correct number for the course next time.");
                    }
                    if (courseInt >= 0 && courseInt <= allCourses.size()){
                        myScanner.reset();
                        String courseName;
                        courseName = university.getCourseByItsIndexInTheList(courseInt).getCourseName();

                        String result = university.createStudentAndAddThemToAClass(studentName, studentAge, courseName);

                        System.out.println("********************  " + result + "  ********************");
                    } else {
                        System.out.println(" Error: course can't be created with the data that you sent, try again with correct inputs.");
                    }

                } else {
                    System.out.println( " Student age should be a number between 1 and 120" );
                }

            } else {
                System.out.println("Student name needs to have at least 1 a-z letter.");
            }

        }

        //Case 4

        private static void createCourseAndAddRelevantDataToIt(University university){
            Scanner myScanner = new Scanner(System.in);
            System.out.println(" Write the name of the new course: ");
            String courseName = myScanner.next();
            myScanner.reset();

            System.out.println(" Write the name of the classroom: ");
            String classroom = myScanner.next();
            myScanner.reset();

            System.out.println(" Send the number of the teacher for this course: ");

            for (int i = 0; i < university.getListOfTeachersToPrint().size(); i++) {
                System.out.println( "    " + i + " " + university.getListOfTeachersToPrint().get(i));
            }
            int courseTeacherIndex = 999;
            try{
                courseTeacherIndex = myScanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Error: enter a valid number according with the available courses.");
            }

            if (courseTeacherIndex > 0 && courseTeacherIndex <= university.getListOfTeachersToPrint().size()){
                myScanner.reset();
                Teacher teacher = university.getListOfTeachers().get(courseTeacherIndex);

                ArrayList<Student> students;
                students = university.getListOfStudents();

                System.out.println("  ");
                for (int i = 0; i < students.size(); i++) {
                    System.out.println(i + " " + students.get(i).getName());
                }
                System.out.println("  ");
                students = selectedStudentsForTheNewCourse(university, students.size());

                String createdOrNot = university.createCourseWithNewAndExistentData(courseName, classroom, teacher.getName(), students);
                if (Objects.equals(createdOrNot, "Course successfully created.")){
                    System.out.println("******************** Course successfully created. ********************");
                }

            }else {
                System.out.println(" Error: select a correct number for the teacher next time.");
            }


        }



//Case 4 helper
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

                        if (listOfStudentIndexes.contains(studentInt)){
                            System.out.println(" The student is already in the course. ");

                            break;
                        }
                        if (studentInt == 999 || studentInt <= 0) {
                            option = 3;
                            break;
                        }
                        if ( studentInt <= studentsSize - 1){
                            listOfStudentIndexes.add(studentInt);
                            System.out.println("   Student " + studentInt + " added to the course.");
                            System.out.println("  ");
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
    }

    //Case 5
    private static void printAllCoursesOfAStudent (University university){
        Scanner myScanner = new Scanner(System.in);

        ArrayList<Student> students;
        ArrayList<String> courses;
        students = university.getListOfStudents();

        System.out.println(" Student list ");
        for (int i = 0; i < students.size(); i++) {
            System.out.println( "    " + i + " " + students.get(i).getName());
        }
        System.out.println("  ");
        System.out.println("Enter the student number from this list to see their courses:");
        System.out.println("  ");

        int studentInt = 999;
        try{
            studentInt = myScanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println(" Your number didn't match with a student.");
        }
       if (studentInt >= 0 && studentInt <= students.size()){

           myScanner.reset();

           Student student = students.get(studentInt);

           courses = university.getStudentListOfCourses(student);
           System.out.println("These are the courses in which " + student.getName() + " is enrolled.");
           System.out.println("  ");
           for (int i = 0; i < courses.size(); i++) {
               System.out.println(" - " + courses.get(i));
           }
       } else {
           System.out.println("Error: make sure the student number is valid.");
       }
    }
//Case 6
        public static void listAllThePeopleOfTheUniversity (University university){

            System.out.println(" These are all the people at the university: ");
            System.out.println("  ");
            ArrayList<Person>  allThePeople  = university.getAllThePeople();

            for (int i = 0; i < allThePeople.size(); i++) {
                System.out.println(" Name: " + allThePeople.get(i).getName() +
                        "           Id " + allThePeople.get(i).getId());
            }
            System.out.println("  ");

        }
}

