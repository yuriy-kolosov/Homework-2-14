package pro.sky.homework214.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.homework214.exception.EmployeeAlreadyAddedException;
import pro.sky.homework214.exception.EmployeeNotFoundException;

import static pro.sky.homework214.constant.EmployeeServiceImplTestConstants.*;

public class EmployeeServiceImplTest {

    private final EmployeeServiceImpl employeeServRes = new EmployeeServiceImpl();

    @Test
    void addEmployee() {

//        Тест: Добавить сотрудника
        Assertions.assertEquals(EMPLOYEE1
                , employeeServRes.addEmployee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID));

//        Тест: Добавить сотрудника, который уже есть в коллекции
        Assertions.assertThrows(EmployeeAlreadyAddedException.class
                , () -> employeeServRes.addEmployee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID));
    }

    @Test
    void removeEmployee() {

//                Добавить сотрудника (для выполнения последующего теста)
        Assertions.assertEquals(EMPLOYEE1
                , employeeServRes.addEmployee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID));

//        Тест: Удалить сотрудника
        Assertions.assertEquals(EMPLOYEE1
                , employeeServRes.removeEmployee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID));

//        Тест: Удалить сотрудника, которого нет в коллекции
        Assertions.assertThrows(EmployeeNotFoundException.class
                , () -> employeeServRes.removeEmployee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID));
    }

    @Test
    void findEmployee() {

//                Добавить сотрудника (для выполнения последующего теста)
        Assertions.assertEquals(EMPLOYEE1
                , employeeServRes.addEmployee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID));

//        Тест: Найти сотрудника
        Assertions.assertEquals(EMPLOYEE1
                , employeeServRes.findEmployee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID));

//        Удалить сотрудника (для выполнения последующего теста)
        Assertions.assertEquals(EMPLOYEE1
                , employeeServRes.removeEmployee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID));

//        Тест: Найти сотрудника, которого нет в коллекции
        Assertions.assertThrows(EmployeeNotFoundException.class
                , () -> employeeServRes.findEmployee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID));
    }

    @Test
    void findAll() {

//                Добавить сотрудника (для выполнения последующего теста)
        Assertions.assertEquals(EMPLOYEE1
                , employeeServRes.addEmployee(EMPLOYEE1_FN, EMPLOYEE1_LN, EMPLOYEE1_SAL, EMPLOYEE1_ID));

//        Тест: найти всех сотрудников
        Assertions.assertEquals(EMPL_TEST4_RES, employeeServRes.findAll());
    }

}
