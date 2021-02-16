package ui;

import java.util.Collections;
import java.util.Comparator;
import models.Employee;
import models.GraphicDesigner;
import static models.EmployeeManagement.*;
import models.Programmer;
import models.TestSpecialist;
import static utilities.Utilities.*;

public class UI {

    //The first menu runs when the program starts.
    public static void runProgram() {

        while (true) {

            System.out.println("\nWelcome to the Employee Management System!");
            System.out.println("Please input number to choose from the menu.");
            System.out.println("1. Employee Management");
            System.out.println("2. Statistics");
            System.out.println("3. Input dummy data");
            System.out.println("0. Exit");

            switch (readInt()) {
                case 1 ->
                    employeeManagement();
                case 2 ->
                    statistics();
                case 3 ->
                    loadDB();
                case 0 ->
                    System.exit(0);
                default ->
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    //Shows the menu for employee management when you get into subcategory of main menu.
    public static void employeeManagement() {

        boolean boolEmployeeManagementMenu = true;
        do {
            System.out.println("\n1. Add employee");
            System.out.println("2. Update employee");
            System.out.println("3. Remove employee by ID");
            System.out.println("4. Remove employee by full name");
            System.out.println("5. Show information about all employees");
            System.out.println("6. Show information about a specific employee");
            System.out.println("0. Go back to previous menu");

            switch (readInt()) {
                case 1 ->
                    addEmployeeByUser();
                case 2 ->
                    updateEmployeeByID();
                case 3 ->
                    removeEmployeeByID();
                case 4 ->
                    removeEmployeeByName();
                case 5 ->
                    printAllEmployees();
                case 6 ->
                    printEmployeeByID();
                case 0 ->
                    boolEmployeeManagementMenu = false;
                default ->
                    System.out.println("Invalid input! Please try again.");
            }
        } while (boolEmployeeManagementMenu);
    }

    //Shows the menu for statistics when you get into subcategory of main menu.
    public static void statistics() {

        boolean boolStatisticsMenu = true;
        do {
            System.out.println("\n1. Average salary");
            System.out.println("2. Gender distribution");
            System.out.println("3. Bonus payments");
            System.out.println("4. Sorting of employee record");
            System.out.println("5. Highest salary in company");
            System.out.println("6. Lowest salary in company");
            System.out.println("0. Go back to previous menu");

            switch (readInt()) {

                case 1 ->
                    calculateAverageSalary();
                case 2 ->
                    genderDistribution();
                case 3 ->
                    bonusMenu();
                case 4 ->
                    sortingMenu();
                case 5 ->
                    findHighestPaidEmployee();
                case 6 ->
                    findLowestPaidEmployee();
                case 0 -> {
                    boolStatisticsMenu = false;
                }
                default ->
                    System.out.println("Invalid input! Please try again.");
            }
        } while (boolStatisticsMenu);
    } //Generates bonus Menu for calculation of Bonus based on different professional roles.

    public static void bonusMenu() {

        boolean boolBonusMenu = true;

        do {
            System.out.println("\n1. Total bonus for all employees ");
            System.out.println("2. Total bonus for all programmers");
            System.out.println("3. Total bonus for all graphic designers");
            System.out.println("4. Total bonus for all test specialists");
            System.out.println("0. Go back to previous menu");

            switch (readInt()) {

                case 1 ->
                    totalBonusPayments();
                case 2 ->
                    totalProgrammersBonusPayments();
                case 3 ->
                    totalGraphicDesignerBonusPayments();
                case 4 ->
                    totalTestSpecialistBonusPayments();
                case 0 -> {
                    boolBonusMenu = false;
                }
                default ->
                    System.out.println("Invalid input. Please try again.");
            }
        } while (boolBonusMenu);
    }

    //Adds the employee by asking different fields of employee from User.
    public static void addEmployeeByUser() {

        boolean boolAddEmployeeByUserMenu = true;
        do {
            System.out.println("\nWhat kind of employee?");
            System.out.println("1. Programmer");
            System.out.println("2. Graphic Designer");
            System.out.println("3. Test Specialist");
            System.out.println("0. Go back to previous menu");
            switch (readInt()) {
                case 1 -> {
                    Programmer p = new Programmer();
                    p.addEmployee();
                }
                case 2 -> {
                    GraphicDesigner g = new GraphicDesigner();
                    g.addEmployee();
                }
                case 3 -> {
                    TestSpecialist t = new TestSpecialist();
                    t.addEmployee();
                }
                case 0 -> {
                    boolAddEmployeeByUserMenu = false;
                }
                default ->
                    System.out.println("Invalid input. Please try again.");
            }

            printAllEmployees();
            System.out.println("");
        } while (boolAddEmployeeByUserMenu);
    }

    private static void sortingMenu() {

        boolean boolSortingMenu = true;

        do {
            System.out.println("\nPlease select the sorting criteria for the employees?");
            System.out.println("1. Ascending sort by First name ");
            System.out.println("2. Descending sort by First name ");
            System.out.println("3. Ascending sort by Last name ");
            System.out.println("4. Descending sort by Last name ");
            System.out.println("5. Incremental sort by Salary ");
            System.out.println("6. Decremental sort by Salary ");
            System.out.println("7. Sort by Employee Number low to high ");
            System.out.println("8. Sort by Employee Number high to low ");
            System.out.println("9. Sort by Employee name and then salary ");

            System.out.println("0. Go back to previous menu");

            switch (readInt()) {
                case 1 -> {

                    employees.sort(Employee.sortByFirstNameAscending);

                    System.out.println("\n====================================================================================================");
                    System.out.println("\t\t\t\t\tSorted by first name ascending");
                    System.out.println("====================================================================================================");

                    printAllEmployees();
                }
                case 2 -> {

                    employees.sort(Employee.sortByFirstNameDescending.reversed());

                    System.out.println("\n====================================================================================================");
                    System.out.println("\t\t\t\t\tSorted by first name descending");
                    System.out.println("====================================================================================================");

                    printAllEmployees();
                }

                case 3 -> {

                    employees.sort(Employee.sortByLastNameAscending);

                    System.out.println("\n====================================================================================================");
                    System.out.println("\t\t\t\t\tSorted by last name ascending");
                    System.out.println("====================================================================================================");

                    printAllEmployees();
                }
                case 4 -> {

                    employees.sort(Employee.sortByLastNameDescending.reversed());

                    System.out.println("\n====================================================================================================");
                    System.out.println("\t\t\t\t\tSorted by last name descending");
                    System.out.println("====================================================================================================");

                    printAllEmployees();
                }

                case 5 -> {

                    employees.sort(Employee.sortBySalaryIncremental);

                    System.out.println("\n====================================================================================================");
                    System.out.println("\t\t\t\t\tSorted by salary in incremental order");
                    System.out.println("====================================================================================================");

                    printAllEmployees();
                }
                case 6 -> {

                    employees.sort(Employee.sortBySalaryDecremental.reversed());

                    System.out.println("\n====================================================================================================");
                    System.out.println("\t\t\t\t\tSorted by salary in decremental order");
                    System.out.println("====================================================================================================");

                    printAllEmployees();
                }

                case 7 -> {

                    employees.sort(Employee.sortByEmployeeNrLowToHigh);

                    System.out.println("\n====================================================================================================");
                    System.out.println("\t\t\t\t\tSorted by employee number in incremental order");
                    System.out.println("====================================================================================================");

                    printAllEmployees();
                }

                case 8 -> {

                    employees.sort(Employee.sortByEmployeeNrHighToLow.reversed());

                    System.out.println("\n====================================================================================================");
                    System.out.println("\t\t\t\t\tSorted by employee number in decremental order");
                    System.out.println("====================================================================================================");

                    printAllEmployees();
                }

                case 9 -> {

                    employees.sort(Employee.sortByNameAndSalary);

                    System.out.println("\n====================================================================================================");
                    System.out.println("\t\t\t\t\tSorted by employee name and then salary");
                    System.out.println("====================================================================================================");

                    printAllEmployees();
                }

                case 0 -> {
                    boolSortingMenu = false;
                }
                default ->
                    System.out.println("Invalid input. Please try again.");
            }

        } while (boolSortingMenu);

    }

}
