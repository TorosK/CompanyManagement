package models;

import static models.EmployeeManagement.employees;
import utilities.Utilities;
import static models.EmployeeManagement.sc;
import utilities.Gender;
import static utilities.Utilities.readBoolean;
import static utilities.Utilities.readDouble;
import static utilities.Utilities.readInt;

public class TestSpecialist extends Employee implements Manageable {

    private boolean ISTQBcertified;
    private static double noOfTestSpecialists;
    private static double noOfMaleTestSpecialists;
    private static double noOfFemaleTestSpecialists;

    {
        noOfTestSpecialists++;
    }

    public TestSpecialist() {

    }

    public TestSpecialist(boolean ISTQBcertified, String firstName, String lastName, Gender gender, double salary) {
        super(firstName, lastName, gender, salary);
        this.ISTQBcertified = ISTQBcertified;

    }

    public boolean isISTQBcertified() {
        return ISTQBcertified;
    }

    public void setISTQBcertified(boolean ISTQBcertified) {
        this.ISTQBcertified = ISTQBcertified;
    }

    public static double getNoOfTestSpecialists() {
        return noOfTestSpecialists;
    }

    public static void setNoOfTestSpecialists(int aNoOfTestSpecialists) {
        noOfTestSpecialists = aNoOfTestSpecialists;
    }

    public static double getNoOfMaleTestSpecialists() {
        return noOfMaleTestSpecialists;
    }

    public static void setNoOfMaleTestSpecialists(int aNoOfMaleTestSpecialists) {
        noOfMaleTestSpecialists = aNoOfMaleTestSpecialists;
    }

    public static double getNoOfFemaleTestSpecialists() {
        return noOfFemaleTestSpecialists;
    }

    public static void setNoOfFemaleTestSpecialists(int aNoOfFemaleTestSpecialists) {
        noOfFemaleTestSpecialists = aNoOfFemaleTestSpecialists;
    }

    public void genderCounter() {
        super.genderCounter();
        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleTestSpecialists += 1;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleTestSpecialists += 1;
        }
    }

    @Override
    public void genderDecrementer() {
        super.genderDecrementer();
        noOfTestSpecialists--;
        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleTestSpecialists--;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleTestSpecialists--;
        } else {
            Employee.noOfOtherGenderEmployees--;
        }
    }

    @Override
    public void addEmployee() {

        super.addEmployee();

        System.out.println("Is Test Specialist ISTQB certified? Write true or false");
        this.setISTQBcertified(readBoolean());

        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleTestSpecialists++;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleTestSpecialists++;
        }

        employees.add(this);
    }

    @Override
    public void updateEmployee() {
        System.out.println("4. ISTQB Certified (true or false)?");
        System.out.println("0. Exit");

        switch (readInt()) {
            case 1:
                System.out.print("New name: ");
                System.out.println("Input First name:");
                this.setFirstName(sc.nextLine());
                System.out.println("Input Last name:");
                this.setLastName(sc.nextLine());
                break;
            case 2:
                System.out.println("New gender: ");
                Gender.readGender(this);
                break;
            case 3:
                System.out.print("New salary: ");
                this.setSalary(readDouble());
                this.bonus();
                break;
            case 4:
                System.out.println("ISTQB Certified (true / false): ");
                this.setISTQBcertified(Utilities.readBoolean());
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input. Please try again.");
        }
    }

    @Override
    public void bonus() {
//        this.setSalaryWithBonus(this.getSalary()*(1.02));
        this.setSalaryWithBonus(this.getSalary() + 500);

        this.setBonus(500.00);

    }

    @Override
    public String toString() {

        return super.toString() + "ISTQB Certified:" + Utilities.theStringTrimmer(String.valueOf(ISTQBcertified));
    }

}
