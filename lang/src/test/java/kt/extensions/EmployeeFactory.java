package kt.extensions;

import java.lang.reflect.Field;

public class EmployeeFactory {

    static final String EMPLOYEE_NAME = "Bela";

    public static Employee createEmployeeWithoutName() throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee("", 10);
        Class<? extends Employee> aClass = employee.getClass();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(employee, null);
        return employee;
    }

    public static Employee createEmployee() throws NoSuchFieldException, IllegalAccessException {
        return new Employee(EMPLOYEE_NAME, 10);
    }
}
