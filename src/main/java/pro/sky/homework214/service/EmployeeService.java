package pro.sky.homework214.service;

import pro.sky.homework214.repository.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int salary, int departmentId);

    Employee removeEmployee(String firstName, String lastName, int salary, int departmentId);

    Employee findEmployee(String firstName, String lastName, int salary, int departmentId);

    Map<Integer, List<Employee>> findAll();

}
