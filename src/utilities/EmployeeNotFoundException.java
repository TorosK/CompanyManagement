package utilities;



public class EmployeeNotFoundException extends Exception{

    // to initialize the Exception class
    public EmployeeNotFoundException() {
        super();
    }

    //  to store an Exception message
    public EmployeeNotFoundException(String message) {
        super(message);
    }

}
