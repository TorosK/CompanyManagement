/**
 *
 * @author toros
 */
package models;

import static models.EmployeeManagement.employees;
import utilities.Utilities;
import static models.EmployeeManagement.sc;
import utilities.Gender;
import static utilities.Utilities.*;

public class Programmer extends Employee implements Manageable {

    private String codeLang;
    private static double noOfProgrammers;
    private static double noOfMaleProgrammers;
    private static double noOfFemaleProgrammers;
    private static double noOfOtherProgrammers;

    {
//        System.out.println("Number of Programmers" + noOfProgrammers);
        noOfProgrammers++;
//        System.out.println("\n\nAn Object of Programmer class is created\n");
//        
//        System.out.println("\nNumber of Programmers" + noOfProgrammers);
//        
//        System.out.println("*******************************************");
    }

    public Programmer() {

    }

    public Programmer(String codeLang, String firstName, String lastName, Gender gender, double salary) {
        super(firstName, lastName, gender, salary);
        this.codeLang = codeLang;

    }

    public static double getNoOfOtherProgrammers() {
        return noOfOtherProgrammers;
    }

    public static void setNoOfOtherProgrammers(double aNoOfOtherProgrammers) {
        noOfOtherProgrammers = aNoOfOtherProgrammers;
    }

    public static double getNoOfProgrammers() {
        return noOfProgrammers;
    }

    public static double getNoOfMaleProgrammers() {
        return noOfMaleProgrammers;
    }

    public static double getNoOfFemaleProgrammers() {
        return noOfFemaleProgrammers;
    }

    public String getCodeLang() {
        return codeLang;
    }

    public void setCodeLang(String codeLang) {
        this.codeLang = codeLang;
    }

    @Override
    public void bonus() {

        this.setSalaryWithBonus(this.getSalary() * (1.01));

        this.setBonus(this.getSalary() * (0.01));

    }

    @Override
    public void addEmployee() {

        super.addEmployee();

        System.out.println("Input programming language:");
        this.setCodeLang(sc.nextLine());

        employees.add(this);
    }

    @Override
    public void genderCounter() {
        super.genderCounter();
        if (this.getGender().getText().equalsIgnoreCase("male")) {
            
            noOfMaleProgrammers++;

        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            
            noOfFemaleProgrammers++;
            
        } else if (this.getGender().getText().equalsIgnoreCase("other")) {
            
            noOfOtherProgrammers++;
        }
    }

    @Override
    public void genderDecrementer() {

        super.genderDecrementer();

        noOfProgrammers--;

        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleProgrammers--;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleProgrammers--;
        } else if (this.getGender().getText().equalsIgnoreCase("other")) {
            noOfOtherProgrammers--;
        }
    }

    @Override
    public void updateEmployee() {
        System.out.println("4. Code language?");
        System.out.println("0. Exit");

        switch (readInt()) {
            case 1 -> {
                System.out.print("New name: ");
                System.out.println("Input First name:");
                this.setFirstName(readString());
                System.out.println("Input Last name:");
                this.setLastName(readString());
                break;
            }
            case 2 -> {
                System.out.println("New gender: ");
                Gender.readGender(this);
            }
            case 3 -> {
                System.out.print("New salary: ");
                this.setSalary(readDouble());
                this.bonus();
            }
            case 4 -> {
                System.out.print("New code language: ");
                this.setCodeLang(sc.nextLine());
            }
            case 0 ->
                System.exit(0);
            default ->
                System.out.println("Wrong input. Please try again.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "CodeLang=" + Utilities.theStringTrimmer(codeLang);
    }
}
