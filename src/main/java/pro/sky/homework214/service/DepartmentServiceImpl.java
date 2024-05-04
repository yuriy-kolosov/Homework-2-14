package pro.sky.homework214.service;

import org.springframework.stereotype.Service;
import pro.sky.homework214.exception.EmployeeInputBadRequest;
import pro.sky.homework214.exception.EmployeeNotFoundException;
import pro.sky.homework214.repository.Employee;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> findAllEmployeesFromDepartment(int departmentId) {

        List<Employee> employeeBook;
        employeeBook = employeeService.findAll().get(departmentId);

        List<Employee> emplDept = null;
        try {
            emplDept = employeeBook.stream()
                    .filter(p -> (p.getDepartmentId() == departmentId))
                    .collect(toList());
        } catch (NullPointerException e) {
            throw new EmployeeInputBadRequest();
        }
        return emplDept;
    }

    @Override
    public int countSumSalaryFromDepartment(int departmentId) {

        List<Employee> employeeBook;
        int sum = 0;

        try {
            employeeBook = employeeService.findAll().get(departmentId);
            sum = employeeBook.stream()
                    .filter(b -> b.getDepartmentId() == departmentId)
                    .mapToInt(b -> b.getSalary())
                    .sum();
        } catch (NullPointerException e) {
            throw new EmployeeNotFoundException();
        }
        return sum;

    }

    @Override
    public int findMaxSalaryFromDepartment(int departmentId) {

        List<Employee> employeeBook;
        final Optional<Employee> max;

        try {
            employeeBook = employeeService.findAll().get(departmentId);
            max = employeeBook.stream()
                    .filter(b -> b.getDepartmentId() == departmentId)
                    .max(Comparator.comparingInt(b -> b.getSalary()));
        } catch (NullPointerException e) {
            throw new EmployeeNotFoundException();
        }
        return max.get().getSalary();

    }

    @Override
    public int findMinSalaryFromDepartment(int departmentId) {

        List<Employee> employeeBook;
        final Optional<Employee> min;

        try {
            employeeBook = employeeService.findAll().get(departmentId);
            min = employeeBook.stream()
                    .filter(b -> b.getDepartmentId() == departmentId)
                    .min(Comparator.comparingInt(b -> b.getSalary()));
        } catch (NullPointerException e) {
            throw new EmployeeNotFoundException();
        }
        return min.get().getSalary();

    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesFromAllDepartments() {

        Map<Integer, List<Employee>> mapDept;

        try {
            mapDept = employeeService.findAll();
        } catch (NullPointerException e) {
            throw new EmployeeInputBadRequest();
        }
        return mapDept;

    }

}
