package utilities;

import java.util.InputMismatchException;
import models.GraphicDesigner;
import static models.EmployeeManagement.*;
import models.Programmer;
import models.TestSpecialist;

public class Utilities {

    public static void loadDB() {

        employees.add(new Programmer("Java", "Toros", "Kutlu", Gender.MALE , 50000.25));
        employees.add(new Programmer("Python", "Åsa", "Karlsson", Gender.FEMALE, 60000.50));
        employees.add(new Programmer("C#", "Ängla", "Karlsson", Gender.FEMALE, 60000.50));
        employees.add(new GraphicDesigner("PhotoShop", "Sara", "Anderson", Gender.FEMALE, 40000));
        employees.add(new GraphicDesigner("Gimp", "Urban", "Petri", Gender.MALE, 35000.999));
        employees.add(new GraphicDesigner("Gimp", "Öjar", "Urban", Gender.MALE, 35000.999));
        employees.add(new TestSpecialist(true, "Maria", "Pirat", Gender.FEMALE, 6500));
        employees.add(new TestSpecialist(false, "Björn", "Karlsson", Gender.MALE, 6500));
        employees.add(new TestSpecialist(false, "Lara", "Karlsson", Gender.FEMALE, 165000.8776554435));
        employees.add(new TestSpecialist(false, "Lara", "Karlsson", Gender.FEMALE, 165000.3776554435));
        employees.add(new TestSpecialist(false, "Lara", "Karlsson", Gender.FEMALE, 165000.1776554435));

        employees.forEach(employee -> {
            employee.bonus();
        });

        printAllEmployees();
        System.out.println("");
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static double readDouble() {

        boolean loop = true;
        double number = -1;

        while (loop) {
            try {
                number = sc.nextDouble();
                sc.nextLine();
                loop = false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please try again.");
            }
        } // loop
        return number;
    }

    public static boolean readBoolean() {

        boolean loop = true;
        boolean certificate = false;

        while (loop) {
            try {
                certificate = sc.nextBoolean();
                sc.nextLine();
                loop = false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please try again.");
            }
        } // loop
        return certificate;
    }

    public static int readInt() {

        boolean loop = true;
        int number = -1;

        while (loop) {
            try {
                number = sc.nextInt();
                sc.nextLine();
                loop = false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input. Please try again.");
            }
        } // loop
        return number;
    }

    public static String theStringTrimmer(String s) {
        if (s.length() <= 15) {
            int max = 15 - s.length();
            for (int i = 0; i <= max; i++) {
                s = s + " ";
            }
        } else {
            s = s.substring(0, 15);
        }
        return s;
    }

    public static void tableHeader() {
        System.out.println("ID              Name            Gender          Salary          Salary & Bonus  Qualifications");
    }

}
