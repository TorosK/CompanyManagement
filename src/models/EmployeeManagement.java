// Toros & Farrukh 
// 2021 feb 16
package models;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.EmployeeNotFoundException;
import static utilities.Utilities.*;

public class EmployeeManagement {

    // nedan "Windows-1252" i Scanner är för att Scanner ska acceptera svenska karaktärer som ÅÄÖ
    public static Scanner sc = new Scanner(System.in, "Windows-1252");
    // System.setProperty("file.encoding", "UTF-8");
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    public static DecimalFormat decimalFormatter = new DecimalFormat("###.##");


//    NumberFormat nf = NumberFormat.getNumberInstance();
//DecimalFormat decimalFormatter = (DecimalFormat)nf;
//df.applyPattern(pattern);
//String output = decimalFormatter.format(value);
//    
    
    public static void updateEmployeeByID() {

        Employee e;
        printAllEmployees();

        System.out.println("Please input employee number:");
        e = getEmployeeById(readInt());

        System.out.println("What would You like to update?");
        System.out.println("Input number to choose from menu:");
        System.out.println("1. Name");
        System.out.println("2. Gender");
        System.out.println("3. Salary");

        e.updateEmployee();

        printAllEmployees();
    }

    public static void printEmployeeByID() {

        printAllEmployees();

        Employee e;

        System.out.println("\n\nPlease input employee number:");
        e = getEmployeeById(readInt());

        if (e != null) {
            System.out.println("\n=================================================================================================================================================");
            System.out.println(e);
            System.out.println("=================================================================================================================================================\n");
        }

        System.out.println("");
    }

    // changed
    public static void removeEmployeeByID() {

        printAllEmployees();

        Employee e;

        System.out.println("Please input employee number:");
        e = getEmployeeById(readInt());

        if (e != null) {
            e.genderDecrementer();
            employees.remove(e);
            System.out.println("\n=============================");
            System.out.println("The Employee has been deleted");
            System.out.println("=============================\n");
        }

        printAllEmployees();
    }

    // not used yet
    public static Employee getEmployeeById(int employeeId) {

        try {

            for (int i = 0; i < employees.size(); i++) {

                if (employees.get(i).getEmployeeNr() == employeeId) {

                    return (employees.get(i));
                }
            }

            throw new EmployeeNotFoundException("The Employee you are looking for is not found");

        } catch (EmployeeNotFoundException e) {

//            e.printStackTrace();
//            System.out.println(e.getMessage());
            System.out.println("\n====================================");
            System.out.println("Employee not found, Please try again!");
            System.out.println("=====================================\n");

            return null;
        }

    }

    public static void removeEmployeeByName() {

        Employee e = new Employee();

        boolean pleaseTryAgain = true;

        printAllEmployees();

        System.out.println("Please input full name of employee:");
        String empName = readString();

//        System.out.println(empName);
//        System.out.println(employees.get(0).getName());
//        Predicate<Employee> condition = employee -> employee.getName().equalsIgnoreCase(empName);
//        employees.removeIf(employee -> employee.getName().equalsIgnoreCase(empName));
        for (int i = (employees.size() - 1); i >= 0; i--) {
            if (employees.get(i).getName().equalsIgnoreCase(empName)) {
                pleaseTryAgain = false;
                e = employees.get(i);
                e.genderDecrementer();
                employees.remove(e);

                System.out.println("\n=============================");
                System.out.println("The Employee has been deleted");
                System.out.println("=============================\n");
            }
        }
//          } else if (!employees.get(i).getName().equalsIgnoreCase(empName)) {
        if (pleaseTryAgain) {
            System.out.println("No such employee was found. Please try again.");
        }
        printAllEmployees();
    }

    public static void printAllEmployees() {

        tableHeader();
        employees.forEach(employee -> {
            System.out.println(employee);
        });
    }

    public static void calculateAverageSalary() {

        double averageSalary = 0;

        for (int i = 0; i < employees.size(); i++) {

            averageSalary = employees.get(i).getSalary() + averageSalary;
        }

        System.out.println("The average salary for all the employees: " + currencyFormatter.format(averageSalary / employees.size()));
    }

    public static void genderDistribution() {

        System.out.println("Male employees percentage: " + decimalFormatter.format((Employee.getNoOfMaleEmployees() * 100) / employees.size()) + "%");
        System.out.println("Female employees percentage: " + decimalFormatter.format((Employee.getNoOfFemaleEmployees() * 100) / employees.size()) + "%");
        System.out.println("Other gender employees percentage: " + decimalFormatter.format((Employee.getNoOfOtherGenderEmployees() * 100) / employees.size()) + "%");

        System.out.println("\nGender distribution among employees respective their professional role");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nPercentage distribution among Programmers:");

        System.out.println("Programmers percentage: " + decimalFormatter.format((Programmer.getNoOfProgrammers() * 100) / employees.size()) + "%");

        System.out.println("Male programmers percentage: " + decimalFormatter.format((Programmer.getNoOfMaleProgrammers() * 100) / Programmer.getNoOfProgrammers()) + "%");
        System.out.println("Female programmers percentage: " + decimalFormatter.format((Programmer.getNoOfFemaleProgrammers() * 100) / Programmer.getNoOfProgrammers()) + "%");
        System.out.println("Other gender programmers percentage: " + decimalFormatter.format((Programmer.getNoOfOtherProgrammers() * 100) / Programmer.getNoOfProgrammers()) + "%");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nPercentage distribution among Graphic Designers:");

        System.out.println("Graphic Designers percentage: " + decimalFormatter.format((GraphicDesigner.getNoOfGraphicDesigners() * 100) / employees.size()) + "%");

        System.out.println("Male Graphic Designers percentage: " + decimalFormatter.format((GraphicDesigner.getNoOfMaleGraphicDesigners() * 100) / GraphicDesigner.getNoOfGraphicDesigners()) + "%");
        System.out.println("Female Graphic Designers percentage: " + decimalFormatter.format((GraphicDesigner.getNoOfFemaleGraphicDesigners() * 100) / GraphicDesigner.getNoOfGraphicDesigners()) + "%");
        System.out.println("Other gender Graphic Designers percentage: " + decimalFormatter.format((GraphicDesigner.getNoOfOtherGraphicDesigners() * 100) / GraphicDesigner.getNoOfGraphicDesigners()) + "%");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nPercentage distribution among Test Specialists:");

        System.out.println("Test Specialists percentage: " + decimalFormatter.format((TestSpecialist.getNoOfTestSpecialists() * 100) / employees.size()) + "%");

        System.out.println("Male Test Specialists percentage: " + decimalFormatter.format((TestSpecialist.getNoOfMaleTestSpecialists() * 100) / TestSpecialist.getNoOfTestSpecialists()) + "%");
        System.out.println("Female Test Specialists percentage: " + decimalFormatter.format((TestSpecialist.getNoOfFemaleTestSpecialists() * 100) / TestSpecialist.getNoOfTestSpecialists()) + "%");
        System.out.println("Other gender Test Specialists percentage: " + decimalFormatter.format((TestSpecialist.getNoOfOtherTestSpecialists() * 100) / TestSpecialist.getNoOfTestSpecialists()) + "%");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

    }

    public static void findHighestPaidEmployee() {

        int highestSalary = 0;

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).getSalary() > employees.get(highestSalary).getSalary()) {

                highestSalary = i;
            }
        }

        double highest = employees.get(highestSalary).getSalary();

        if (highestSalary != 0) {
            tableHeader();
        }

        employees.stream().filter(employee -> (employee.getSalary() == highest)).forEachOrdered(employee -> {
            System.out.println(employee);
        }); //System.out.println(employees.get(highestSalary));
    }

    public static void findLowestPaidEmployee() {

        int lowestSalary = 0;

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).getSalary() < employees.get(lowestSalary).getSalary()) {

                lowestSalary = i;
            }
        }
        double lowest = employees.get(lowestSalary).getSalary();

        if (lowestSalary != 0) {
            tableHeader();
        }

        employees.stream().filter(employee -> (employee.getSalary() == lowest)).forEachOrdered(employee -> {
            System.out.println(employee);
        });
    }

    public static void totalBonusPayments() {

        double totalBonus = 0;

        for (Employee employee : employees) {

            totalBonus = employee.getBonus() + totalBonus;

        }
        System.out.println("Total bonus for all the employees: " + currencyFormatter.format(totalBonus));
    }

    public static void totalProgrammersBonusPayments() {

        double totalProgrammerBonus = 0;

        for (Employee employee : employees) {

            if (employee instanceof Programmer) {
                totalProgrammerBonus = employee.getBonus() + totalProgrammerBonus;
            }

        }
        System.out.println("Total bonus for all the Programmers: " + totalProgrammerBonus);
    }

    public static void totalGraphicDesignerBonusPayments() {

        double totalGraphicDesignerBonus = 0;

        for (Employee employee : employees) {

            if (employee instanceof GraphicDesigner) {
                totalGraphicDesignerBonus = employee.getBonus() + totalGraphicDesignerBonus;
            }

        }
        System.out.println("Total bonus for all the Graphic Designers: " + totalGraphicDesignerBonus);
    }

    public static void totalTestSpecialistBonusPayments() {

        double totalTestSpecialistBonus = 0;

        for (Employee employee : employees) {

            if (employee instanceof TestSpecialist) {
                totalTestSpecialistBonus = employee.getBonus() + totalTestSpecialistBonus;
            }

        }
        System.out.println("Total bonus for all the Test Specialists: " + totalTestSpecialistBonus);
    }

    // Not used
    public static void testsorting() {

//        System.out.println("\nBefore sorting all the information");
//        printAllEmployees();
//        Comparator<Employee> sortEmployeebyName = (e1, e2) -> (int) (e1.getSalary() - e2.getSalary());
//        employees.sort(sortEmployeebyName);
//        System.out.println("\nAfter sorting all the information");
//        printAllEmployees();
        Comparator<Employee> sortByNameAcsending = (e1, e2) -> sortByEmployeeName(e1, e2);
        Comparator<Employee> sortByNameDecending = (e1, e2) -> -sortByEmployeeName(e1, e2);
        Comparator<Employee> sortBySalary = (e1, e2) -> -sortByEmployeeSalary(e1, e2);
        Comparator<Employee> sortBySalaryStigande = (e1, e2) -> sortByEmployeeSalary(e1, e2);

        employees.sort(sortByNameAcsending);

        System.out.println("\n====================================================================================================");
        System.out.println("\t\t\t\t\tSorted by name Ascending");
        System.out.println("====================================================================================================");

        employees.forEach(e -> {
            System.out.println(e);
        });
        employees.sort(sortByNameDecending);

        System.out.println("\n======================================================================================================");
        System.out.println("\t\t\t\t\tSorted by name Decending");
        System.out.println("======================================================================================================");

        employees.forEach(e -> {
            System.out.println(e);
        });

        employees.sort(sortBySalary);
        System.out.println("\n======================================================================================================");
        System.out.println("\t\t\t\t\tSorted by Salary fallande");
        System.out.println("======================================================================================================");

        employees.forEach(e -> {
            System.out.println(e);
        });

        employees.sort(sortBySalaryStigande);
        System.out.println("\n=======================================================================================================");
        System.out.println("\t\t\t\t\tSorted by Salary stigande");
        System.out.println("=======================================================================================================");

        employees.forEach(e -> {
            System.out.println(e);
        });

    }

    // Not used
    public static int sortByEmployeeName(Employee e1, Employee e2) {
        String swedishRule = "< a,A < b,B < c,C < d,D < e,E < f,F "
                + "< g,G < h,H < i,I < j,J < k,K < l,L "
                + "< m,M < n,N < o,O < p,P < q,Q < r,R "
                + "< s,S < t,T < u,U < v,V < w,W < x,X "
                + "< y,Y < z,Z < \u00e5,\u00c5 < \u00e4,\u00c4 < \u00f6,\u00d6";

        RuleBasedCollator swedishCollator = null;

        try {
            swedishCollator = new RuleBasedCollator(swedishRule);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return swedishCollator.compare(e1.getName(), e2.getName());
    }

    // Not used
    public static int sortByEmployeeSalary(Employee e1, Employee e2) {

        return Double.compare(e1.getSalary(), e2.getSalary());
    }

}
