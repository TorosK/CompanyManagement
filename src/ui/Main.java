package ui;

// import static utilities.Utilities.readDouble2;

import static models.EmployeeManagement.sc;
import utilities.EmployeeNotFoundException;
import static utilities.Utilities.methodX;

// import static utilities.Utilities.readInt2;
public class Main {

    public static void main(String[] args) {

        // double d = readDouble2();
        // System.out.println(d);
        // int i = readInt2();
        // System.out.println(i);
        
//            System.out.println("enter number");
//            methodX(sc.nextDouble());
            
        try{
         UI.runProgram();
         throw new EmployeeNotFoundException("The Employee you looking is not found");
        }
        catch(EmployeeNotFoundException e)
        {   
            
        }
    }
}




//    public static Employee getEmployeeById(int employeeId) {
//        try {
//            for (int i = 0; i < employees.size(); i++) {
//
//                if (employees.get(i).getEmployeeNr() == employeeId) {
//
//                    return (employees.get(i));
//                }
//            }
//            throw new EmployeeNotFoundException("The Employee you are looking for is not found");
//        } catch (EmployeeNotFoundException e) {
//            
//            e.printStackTrace();
//            
////            System.out.println(e.getMessage());
//
//            System.out.println("\n====================================");
//            System.out.println("Employee not found, Please try again!");
//            System.out.println("=====================================\n");
//
//            return null;
//        }
//
//    }
//
//    public static void removeEmployeeByName() {
//
//        Employee e = new Employee();
//
//        boolean pleaseTryAgain = true;
//
//        printAllEmployees();
//
//        System.out.println("Please input full name of employee:");
//        String empName = readString();
////        System.out.println(empName);
////        System.out.println(employees.get(0).getName());
//
////        Predicate<Employee> condition = employee -> employee.getName().equalsIgnoreCase(empName);
////        employees.removeIf(employee -> employee.getName().equalsIgnoreCase(empName));
//
//    try{
//        for (int i = (employees.size() - 1); i >= 0; i--) {
//            if (employees.get(i).getName().equalsIgnoreCase(empName)) {
//                pleaseTryAgain = false;
//                e = employees.get(i);
//                e.genderDecrementer();
//                employees.remove(e);
//
//                System.out.println("\n=============================");
//                System.out.println("The Employee has been deleted");
//                System.out.println("=============================\n");
//            }
//        }
//        throw new EmployeeNotFoundException("Employee by Name is not found");
//    }
//    catch(EmployeeNotFoundException nfe){
////          } else if (!employees.get(i).getName().equalsIgnoreCase(empName)) {
//            nfe.printStackTrace();
////        if (pleaseTryAgain) {
////            System.out.println("No such employee was found. Please try again.");
////        }
//    }
//        printAllEmployees();
//    }
