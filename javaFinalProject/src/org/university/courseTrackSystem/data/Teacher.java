package org.university.courseTrackSystem.data;

import java.util.Objects;


public class Teacher extends Person {
//attributes
    private String contractType;
    private int experienceYears;
    private double baseHourlySalary;
    private double monthlySalary;
//constructor

    /***
     * Creates a new teacher with id (from the class Person) and also with these parameters:
     * @param name of the teacher, it's a String, and it needs at least 1 letter to be valid.
     * @param contractType type of employee contract, it can be full-time or part-time.
     * @param experienceYears years of experience as a teacher.
     * @param baseHourlySalary salary per hour.
     */
    public Teacher(String name, String contractType, int experienceYears,  double baseHourlySalary) {
        super(name);
        this.contractType = contractType;
        this.experienceYears = experienceYears;
        this.baseHourlySalary = baseHourlySalary;

        if (Objects.equals(contractType,  "full-time")){
            this.monthlySalary = 4 * ( 40 * (baseHourlySalary * (experienceYears * 1.1)));
        }
        if (Objects.equals(contractType,  "part-time")){
            this.monthlySalary = 4 * ( 20 * baseHourlySalary);
        }
    }
//getters


    public String getContractType() {
        return this.contractType;
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public int getExperienceYears() {
        return this.experienceYears;
    }


}
