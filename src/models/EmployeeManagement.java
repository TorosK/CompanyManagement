package models;
//
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utilities.Utilities.*;

public class EmployeeManagement {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static DecimalFormat df = new DecimalFormat("###.##");

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

        System.out.println("\n\nPlease input employee number:");
        System.out.println(getEmployeeById(readInt()));

        System.out.println("");
    }

    public static void removeEmployeeByID() {

        printAllEmployees();

        Employee e;

        System.out.println("Please input employee number:");
        e = getEmployeeById(readInt());
        employees.remove(e);

        e.genderDecrementer();

        printAllEmployees();
    }

    public static Employee getEmployeeById(int employeeId) {

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).getEmployeeNr() == employeeId) {

                return (employees.get(i));
            }
        }
        return null;
    }

    public static void removeEmployeeByName() {

        Employee e = new Employee();

        printAllEmployees();

        System.out.println("Please input employee name:");
        String empName = sc.nextLine();

//        Predicate<Employee> condition = employee -> employee.getName().equalsIgnoreCase(empName);
//        employees.removeIf(employee -> employee.getName().equalsIgnoreCase(empName));
        for (int i = (employees.size() - 1); i > 0; i--) {
            if (employees.get(i).getName().equalsIgnoreCase(empName)) {
                e = employees.get(i);
                employees.remove(e);
            }
        }
        System.out.println("\n=============================");
        System.out.println("The Employee has been deleted");
        System.out.println("=============================\n");
        e.genderDecrementer();
        printAllEmployees();
    }

    public static void printAllEmployees() {

        tableHeader();
        employees.forEach(employee -> {
            System.out.println(employee);
        });
    }

    public static void calculateAverageSalary() {

        double averageSalaray = 0;

        for (int i = 0; i < employees.size(); i++) {

            averageSalaray = employees.get(i).getSalary() + averageSalaray;
        }

        System.out.println("The average salaray for all the employees: " + averageSalaray / employees.size());
    }

    public static void genderDistribution() {

        System.out.println("Male employees percentage: " + df.format((Employee.getNoOfMaleEmployees() * 100) / employees.size()) + "%");
        System.out.println("FeMale employees percentage: " + df.format((Employee.getNoOfFemaleEmployees() * 100) / employees.size()) + "%");

        System.out.println("\nGender distribution among employees respective their professional role");

        System.out.println("\nPrecentage distribution among Programmers");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Programmers percentage: " + df.format((Programmer.getNoOfProgrammers() * 100) / employees.size()) + "%" );

        System.out.println("Male programmers percentage: " + df.format((Programmer.getNoOfMaleProgrammers() * 100) / Programmer.getNoOfProgrammers()) + "%");
        System.out.println("Female programmers percentage: " + df.format((Programmer.getNoOfFemaleProgrammers() * 100) / Programmer.getNoOfProgrammers()) + "%");

        System.out.println("\nPrecentage distribution among graphicDesigners");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        System.out.println("GraphicDesigners percentage: " + df.format((GraphicDesigner.getNoOfGraphicDesigners() * 100) / employees.size()) + "%" );

        System.out.println("Male graphicDesigners percentage: " + df.format((GraphicDesigner.getNoOfMaleGraphicDesigners() * 100) / GraphicDesigner.getNoOfGraphicDesigners()) + "%");
        System.out.println("Female graphicDesigners percentage: " + df.format((GraphicDesigner.getNoOfFemaleGraphicDesigners() * 100) / GraphicDesigner.getNoOfGraphicDesigners()) + "%");

        System.out.println("\nPrecentage distribution among testSpecialists");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

        System.out.println("TestSpecialists percentage: " + df.format((TestSpecialist.getNoOfTestSpecialists() * 100) / employees.size()) + "%" );

        System.out.println("Male testSpecialists percentage: " + df.format((TestSpecialist.getNoOfMaleTestSpecialists() * 100) / TestSpecialist.getNoOfTestSpecialists()) + "%");
        System.out.println("Female testSpecialists percentage: " + df.format((TestSpecialist.getNoOfFemaleTestSpecialists() * 100) / TestSpecialist.getNoOfTestSpecialists()) + "%");

        System.out.println("\nPrecentage distribution among other category for gender");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Other gender for employees percentage: " + df.format((Employee.noOfOtherGenderEmployees * 100) / employees.size()) + "%" );

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
        System.out.println("Total bonus for all the employees: " + totalBonus);
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

    public static int sortByEmployeeSalary(Employee e1, Employee e2) {

        return Double.compare(e1.getSalary(), e2.getSalary());
    }

}
