package models;

import static models.EmployeeManagement.employees;
import static models.EmployeeManagement.sc;
import utilities.Gender;
import static utilities.Utilities.*;

public class GraphicDesigner extends Employee implements Manageable {

    private String techStack;
    private static double noOfGraphicDesigners;
    private static double noOfMaleGraphicDesigners;
    private static double noOfFemaleGraphicDesigners;
    private static double noOfOtherGraphicDesigners;

    {
        noOfGraphicDesigners++;
    }

    public GraphicDesigner() {

    }

    public GraphicDesigner(String techStack, String firstName, String lastName, Gender gender, double salary) {
        super(firstName, lastName, gender, salary);
        this.techStack = techStack;

    }

    public static double getNoOfOtherGraphicDesigners() {
        return noOfOtherGraphicDesigners;
    }

    public static void setNoOfOtherGraphicDesigners(double aNoOfOtherGraphicDesigners) {
        noOfOtherGraphicDesigners = aNoOfOtherGraphicDesigners;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public static double getNoOfGraphicDesigners() {
        return noOfGraphicDesigners;
    }

    public static void setNoOfGraphicDesigners(int aNoOfGraphicDesigners) {
        noOfGraphicDesigners = aNoOfGraphicDesigners;
    }

    public static double getNoOfMaleGraphicDesigners() {
        return noOfMaleGraphicDesigners;
    }

    public static void setNoOfMaleGraphicDesigners(int aNoOfMaleGraphicDesigners) {
        noOfMaleGraphicDesigners = aNoOfMaleGraphicDesigners;
    }

    public static double getNoOfFemaleGraphicDesigners() {
        return noOfFemaleGraphicDesigners;
    }

    public static void setNoOfFemaleGraphicDesigners(int aNoOfFemaleGraphicDesigners) {
        noOfFemaleGraphicDesigners = aNoOfFemaleGraphicDesigners;
    }

    @Override
    public void addEmployee() {

        super.addEmployee();

        System.out.println("Input Tech Stack:");
        this.setTechStack(sc.nextLine());
        employees.add(this);
    }

    @Override
    public void genderCounter() {
        
        super.genderCounter();
        
        if (this.getGender().getText().equalsIgnoreCase("male")) {
            
            noOfMaleGraphicDesigners++;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            
            noOfFemaleGraphicDesigners++;
        } else if (this.getGender().getText().equalsIgnoreCase("other")) {

            noOfOtherGraphicDesigners++;
        }
    }

    @Override
    public void genderDecrementer() {

        super.genderDecrementer();

        noOfGraphicDesigners--;

        if (this.getGender().getText().equalsIgnoreCase("male")) {
            noOfMaleGraphicDesigners--;
        } else if (this.getGender().getText().equalsIgnoreCase("female")) {
            noOfFemaleGraphicDesigners--;
        } else if (this.getGender().getText().equalsIgnoreCase("other")) {
            noOfOtherGraphicDesigners--;
        }
    }

    @Override
    public void updateEmployee() {
        System.out.println("4. Tech Stack?");
        System.out.println("0. Exit");

        switch (readInt()) {
            case 1 -> {
                System.out.print("New name: ");
                System.out.println("Input First name:");
                this.setFirstName(readString());
                System.out.println("Input Last name:");
                this.setLastName(readString());
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
                System.out.println("New tech stack: ");
                this.setTechStack(sc.nextLine());
            }
            case 0 ->
                System.exit(0);
            default ->
                System.out.println("Wrong input. Please try again.");
        }
    }

    @Override
    public void bonus() {

        this.setSalaryWithBonus(this.getSalary() * (1.025));

        this.setBonus(this.getSalary() * (0.025));
    }

    @Override
    public String toString() {
        return super.toString() + "TechStack:" + theStringTrimmer(techStack);
    }

}
