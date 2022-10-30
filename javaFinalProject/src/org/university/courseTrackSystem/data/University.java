package org.university.courseTrackSystem.data;
import java.util.ArrayList;
import java.util.Objects;

public class University {

    private String universityName;
    private ArrayList<Student> listOfStudents;
    private ArrayList<Teacher> listOfTeachers;
    private ArrayList<Course> listOfCourses;

    public University(String name){
        this.universityName = name;
        this.listOfStudents = new ArrayList<Student>();
        this.listOfTeachers = new ArrayList<Teacher>();
        this.listOfCourses = new ArrayList<Course>();
    }
//getters
    public ArrayList<Student> getListOfStudents(){
        return this.listOfStudents;
    }
    public ArrayList<Teacher> getListOfTeachers() {
        return this.listOfTeachers;
    }
    public ArrayList<Course> getListOfCourses() {
        return this.listOfCourses;
    }
    public ArrayList<String> getListOfTeachersToPrint(){
            ArrayList<Teacher> allTeachers = getListOfTeachers();
            ArrayList<String> allTeachersInformation = new ArrayList<String>();

            for (int i = 0; i < allTeachers.size(); i++) {
                allTeachersInformation.add("Account Id: " + allTeachers.get(i).getId() +
                        "  Name: " + allTeachers.get(i).getName() +
                        "  Contract Type: " + allTeachers.get(i).getContractType() +
                        "  Monthly salary: " + allTeachers.get(i).getMonthlySalary() +
                        "  Experience Years: " + allTeachers.get(i).getExperienceYears());
            }
            return allTeachersInformation;
        }

//setters
    public void setStudent(Student student){
        this.listOfStudents.add(student);
    }
    public void setTeacher(Teacher teacher) {
        this.listOfTeachers.add(teacher);
    }
    public void setCourse(Course course) {
        this.listOfCourses.add(course);
    }

    public ArrayList<String> returnAllCourses (){
        ArrayList<String> Courses = new ArrayList<String>();
        for (int i = 0; i < listOfCourses.size(); i++) {
             Courses.add(listOfCourses.get(i).getCourseName());
        }
        return Courses;
    };

    public Course getCourseByItsIndexInTheList(int indexPosition){
        return listOfCourses.get(indexPosition);
    }

    public String createStudentAndAddThemToAClass(String name, int age, String courseName){
        Student newStudent = new Student(name, age);

        for (int i = 0; i < listOfCourses.size(); i++) {
            if (Objects.equals(listOfCourses.get(i).getCourseName(), courseName)){
                listOfCourses.get(i).setOneStudentInTheCourse(newStudent);
                return "Student added successfully";
            }
        }
        return "The course provided does not exist.";
    };


    public ArrayList<String> getStudentListOfCourses( Student student ){
        ArrayList<String> courses = new ArrayList<String >();

        for (int i = 0; i < listOfCourses.size(); i++) {
            if (listOfCourses.get(i).getListOfStudentsInTheCourse().contains(student)){
                courses.add(listOfCourses.get(i).getCourseName());
            }
        }
        return courses;
    }

}
