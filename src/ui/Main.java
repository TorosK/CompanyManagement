package ui;


import utilities.EmployeeNotFoundException;

public class Main {

    public static void main(String[] args) {

        try{
         UI.runProgram();
         throw new EmployeeNotFoundException("The Employee you looking is not found");
        }
        catch(EmployeeNotFoundException e)
        {   
            System.out.println("The Employee you looking is not found");
        }
    }
}