package models;

import java.util.Comparator;
import static utilities.Utilities.*;
import utilities.Gender;
import static models.EmployeeManagement.currencyFormatter;

public class Employee {

    public static int employeeNumberGenerator = 1;

    public static double getNoOfOtherGenderEmployees() {
        return noOfOtherGenderEmployees;
    }

    public static void setNoOfOtherGenderEmployees(double aNoOfOtherGenderEmployees) {
        noOfOtherGenderEmployees = aNoOfOtherGenderEmployees;
    }
    private int employeeNr;
    private String firstName;
    private String lastName;
    private Gender gender;
    private double salary;
    private double bonus;
    private double salaryWithBonus;
    private static double noOfMaleEmployees;
    private static double noOfFemaleEmployees;
    private static double noOfOtherGenderEmployees;
    
    // Comparable objekt för att jämföra värden och sortera. Kolla UI.
    public static Comparator<Employee> sortByNameAndSalary = Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary); // :: betyder ...
    public static Comparator<Employee> sortByFirstNameAscending = Comparator.comparing(e -> e.getFirstName());
    public static Comparator<Employee> sortByFirstNameDescending = Comparator.comparing(e -> e.getFirstName());
    public static Comparator<Employee> sortByLastNameAscending = Comparator.comparing(e -> e.getLastName());
    public static Comparator<Employee> sortByLastNameDescending = Comparator.comparing(e -> e.getLastName());
    public static Comparator<Employee> sortBySalaryIncremental = Comparator.comparing(e -> e.getSalary());
    public static Comparator<Employee> sortBySalaryDecremental = Comparator.comparing(e -> e.getSalary());
    public static Comparator<Employee> sortByEmployeeNrLowToHigh = Comparator.comparing(e -> e.getEmployeeNr());
    public static Comparator<Employee> sortByEmployeeNrHighToLow = Comparator.comparing(e -> e.getEmployeeNr());

    public Employee() {
        this.employeeNr = employeeNumberGenerator++;
    }

    public Employee(String firstName, String lastName, Gender gender, double salary) {

        this.employeeNr = employeeNumberGenerator++;
        setName(firstName, lastName);
        this.gender = gender;
        this.salary = salary;
        this.salaryWithBonus = salary;

        this.genderCounter();

    }

    private void setName(String firstName, String surName) {
        this.firstName = firstName;
        this.lastName = surName;
    }

    public String getName() {
        return this.firstName.concat(" ").concat(lastName);

    }

    public static double getNoOfMaleEmployees() {
        return noOfMaleEmployees;
    }

    public static void setNoOfMaleEmployees(int aNoOfMaleEmployees) {
        noOfMaleEmployees = aNoOfMaleEmployees;
    }

    public static double getNoOfFemaleEmployees() {
        return noOfFemaleEmployees;
    }

    public static void setNoOfFemaleEmployees(int aNoOfFemaleEmployees) {
        noOfFemaleEmployees = aNoOfFemaleEmployees;
    }

    public double getSalaryWithBonus() {
        return salaryWithBonus;
    }

    public void setSalaryWithBonus(double salaryWithBonus) {
        this.salaryWithBonus = salaryWithBonus;
    }

    public int getEmployeeNr() {
        return employeeNr;
    }

    public void setEmployeeNr(int employeeNr) {
        this.employeeNr = employeeNr;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void bonus() {
    }

    public void updateEmployee() {
    }

    public void genderCounter() {

        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleEmployees++;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleEmployees++;
        } else if (this.getGender().getText().equalsIgnoreCase("other")) {
            noOfOtherGenderEmployees++;
        }
    }

    public void genderDecrementer() {

        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleEmployees--;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleEmployees--;
        } else if (this.getGender().getText().equalsIgnoreCase("other")){
            noOfOtherGenderEmployees--;
        }
    }

    public void addEmployee() {

        System.out.println("Input First name:");
        this.firstName = readString();
        System.out.println("Input Last name:");
        this.lastName = readString();
        System.out.println("Input gender:");
        Gender.readGender(this);
        System.out.println("Input salary:");
        this.setSalary(readDouble());

        this.bonus();
        this.genderCounter();

    }

    @Override
    public String toString() {

        return theStringTrimmer(String.valueOf(employeeNr)) + theStringTrimmer(getName()) + theStringTrimmer(gender.getText()) + theStringTrimmer(currencyFormatter.format(salary)) + theStringTrimmer(currencyFormatter.format(salaryWithBonus));

    }
}
