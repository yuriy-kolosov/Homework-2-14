package pro.sky.homework214.constant;

import pro.sky.homework214.repository.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentServiceImplTestConstant {

    public static final String EMPLOYEE2_FN = "Petr";
    public static final String EMPLOYEE2_LN = "Petrov";
    public static final int EMPLOYEE2_SAL = 120;
    public static final int EMPLOYEE2_ID = 2;

    public static final String EMPLOYEE3_FN = "Sidor";
    public static final String EMPLOYEE3_LN = "Sidorov";
    public static final int EMPLOYEE3_SAL = 90;
    public static final int EMPLOYEE3_ID = 3;

    public static final String EMPLOYEE4_FN = "Fedor";
    public static final String EMPLOYEE4_LN = "Fedorov";
    public static final int EMPLOYEE4_SAL = 80;
    public static final int EMPLOYEE4_ID = 3;

    public static final String EMPLOYEE5_FN = "Semen";
    public static final String EMPLOYEE5_LN = "Semenov";
    public static final int EMPLOYEE5_SAL = 110;
    public static final int EMPLOYEE5_ID = 4;

    public static final Employee EMPLOYEE2 = new Employee(EMPLOYEE2_FN, EMPLOYEE2_LN, EMPLOYEE2_SAL, EMPLOYEE2_ID);
    public static final Employee EMPLOYEE3 = new Employee(EMPLOYEE3_FN, EMPLOYEE3_LN, EMPLOYEE3_SAL, EMPLOYEE3_ID);
    public static final Employee EMPLOYEE4 = new Employee(EMPLOYEE4_FN, EMPLOYEE4_LN, EMPLOYEE4_SAL, EMPLOYEE4_ID);
    public static final Employee EMPLOYEE5 = new Employee(EMPLOYEE5_FN, EMPLOYEE5_LN, EMPLOYEE5_SAL, EMPLOYEE5_ID);

    public static final List<Employee> EMPL_LIST2 = List.of(EMPLOYEE2);
    public static final List<Employee> EMPL_LIST3 = List.of(EMPLOYEE3, EMPLOYEE4);
    public static final List<Employee> EMPL_LIST4 = List.of(EMPLOYEE5);

    public static final int DEPT2 = 2;
    public static final int DEPT3 = 3;
    public static final int DEPT4 = 4;

    public static final int DEPT5 = 5;

    public static final Map<Integer, List<Employee>> DEPT_MAP_RES = new
            HashMap<>(Map.of(DEPT2, EMPL_LIST2, DEPT3, EMPL_LIST3, DEPT4, EMPL_LIST4));

    public static final int DEPT2_SUM = 120;
    public static final int DEPT3_SUM = 170;
    public static final int DEPT4_SUM = 110;

    public static final int DEPT2_MAX = 120;
    public static final int DEPT3_MAX = 90;
    public static final int DEPT4_MAX = 110;

    public static final int DEPT2_MIN = 120;
    public static final int DEPT3_MIN = 80;
    public static final int DEPT4_MIN = 110;

}
