package pro.sky.homework214.constant;

import pro.sky.homework214.repository.Employee;

import java.util.*;

public class EmployeeServiceImplTestConstants {

    public static final String EMPLOYEE1_FN = "Ivan";
    public static final String EMPLOYEE1_LN = "Ivanov";
    public static final int EMPLOYEE1_SAL = 100;
    public static final int EMPLOYEE1_ID = 1;

    public static final Employee EMPLOYEE1 = new Employee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID);
    public static final List<Employee> EMPL_LIST1 = List.of(EMPLOYEE1);

    public static final Map<Integer, List<Employee>> EMPL_TEST4_RES = new HashMap<>(Map.of(1, EMPL_LIST1));

}
