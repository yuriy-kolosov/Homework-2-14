package pro.sky.homework214.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework214.exception.EmployeeInputBadRequest;
import pro.sky.homework214.exception.EmployeeNotFoundException;

import static org.mockito.Mockito.when;
import static pro.sky.homework214.constant.DepartmentServiceImplTestConstant.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImplMock;

    @Test
    void findAllEmployeesFromDepartment() {

//       Тест: проверка работоспособности
        final DepartmentServiceImpl departmentServiceImplRes = new DepartmentServiceImpl(employeeServiceMock);
        when(employeeServiceMock.findAll()).thenReturn(DEPT_MAP_RES);
        Assertions.assertEquals(EMPL_LIST2, departmentServiceImplRes.findAllEmployeesFromDepartment(DEPT2));
        Assertions.assertEquals(EMPL_LIST3, departmentServiceImplRes.findAllEmployeesFromDepartment(DEPT3));
        Assertions.assertEquals(EMPL_LIST4, departmentServiceImplRes.findAllEmployeesFromDepartment(DEPT4));

//       Тест: проверка на выброс исключения
        Assertions.assertThrows(EmployeeInputBadRequest.class
                , () -> departmentServiceImplRes.findAllEmployeesFromDepartment(DEPT5));

    }

    @Test
    void countSumSalaryFromDepartment() {

//       Тест: проверка работоспособности
        final DepartmentServiceImpl departmentServiceImplRes = new DepartmentServiceImpl(employeeServiceMock);
        when(employeeServiceMock.findAll()).thenReturn(DEPT_MAP_RES);
        Assertions.assertEquals(DEPT2_SUM, departmentServiceImplRes.countSumSalaryFromDepartment(DEPT2));
        Assertions.assertEquals(DEPT3_SUM, departmentServiceImplRes.countSumSalaryFromDepartment(DEPT3));
        Assertions.assertEquals(DEPT4_SUM, departmentServiceImplRes.countSumSalaryFromDepartment(DEPT4));
//       Тест: проверка на выброс исключения
        Assertions.assertThrows(EmployeeNotFoundException.class
                , () -> departmentServiceImplRes.countSumSalaryFromDepartment(DEPT5));

    }

    @Test
    void findMaxSalaryFromDepartment() {

//       Тест: проверка работоспособности
        final DepartmentServiceImpl departmentServiceImplRes = new DepartmentServiceImpl(employeeServiceMock);
        when(employeeServiceMock.findAll()).thenReturn(DEPT_MAP_RES);
        Assertions.assertEquals(DEPT2_MAX, departmentServiceImplRes.findMaxSalaryFromDepartment(DEPT2));
        Assertions.assertEquals(DEPT3_MAX, departmentServiceImplRes.findMaxSalaryFromDepartment(DEPT3));
        Assertions.assertEquals(DEPT4_MAX, departmentServiceImplRes.findMaxSalaryFromDepartment(DEPT4));

//       Тест: проверка на выброс исключения
        Assertions.assertThrows(EmployeeNotFoundException.class
                , () -> departmentServiceImplRes.findMaxSalaryFromDepartment(DEPT5));

    }

    @Test
    void findMinSalaryFromDepartment() {

//       Тест: проверка работоспособности
        final DepartmentServiceImpl departmentServiceImplRes = new DepartmentServiceImpl(employeeServiceMock);
        when(employeeServiceMock.findAll()).thenReturn(DEPT_MAP_RES);
        Assertions.assertEquals(DEPT2_MIN, departmentServiceImplRes.findMinSalaryFromDepartment(DEPT2));
        Assertions.assertEquals(DEPT3_MIN, departmentServiceImplRes.findMinSalaryFromDepartment(DEPT3));
        Assertions.assertEquals(DEPT4_MIN, departmentServiceImplRes.findMinSalaryFromDepartment(DEPT4));
//       Тест: проверка на выброс исключения
        Assertions.assertThrows(EmployeeNotFoundException.class
                , () -> departmentServiceImplRes.findMinSalaryFromDepartment(DEPT5));

    }

    @Test
    void findAllEmployeesFromAllDepartments() {

//       Тест: проверка на выброс исключения
        final DepartmentServiceImpl departmentServiceImplRes2 = new DepartmentServiceImpl(null);
        Assertions.assertThrows(EmployeeInputBadRequest.class
                , () -> departmentServiceImplRes2.findAllEmployeesFromAllDepartments());

//       Тест: проверка работоспособности
        final DepartmentServiceImpl departmentServiceImplRes = new DepartmentServiceImpl(employeeServiceMock);
        when(employeeServiceMock.findAll()).thenReturn(DEPT_MAP_RES);
        Assertions.assertEquals(DEPT_MAP_RES, departmentServiceImplRes.findAllEmployeesFromAllDepartments());

    }

}
