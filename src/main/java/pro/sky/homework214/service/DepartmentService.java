package pro.sky.homework214.service;

import pro.sky.homework214.repository.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<Employee> findAllEmployeesFromDepartment(int departmentId);

    Map<Integer, List<Employee>> findAllEmployeesFromAllDepartments();

    int countSumSalaryFromDepartment(int departmentId);

    int findMaxSalaryFromDepartment(int departmentId);

    int findMinSalaryFromDepartment(int Id);

}
