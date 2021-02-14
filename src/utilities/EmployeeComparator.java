
package utilities;

import models.Employee;


@FunctionalInterface
public interface EmployeeComparator {
    
    int employeeCompare(Employee e1, Employee e2);
}
