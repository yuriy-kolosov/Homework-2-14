package pro.sky.homework214.service;

import org.springframework.stereotype.Service;
import pro.sky.homework214.exception.EmployeeAlreadyAddedException;
import pro.sky.homework214.exception.EmployeeInputBadRequest;
import pro.sky.homework214.exception.EmployeeNotFoundException;
import pro.sky.homework214.repository.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //                                                      Домашнее задание 2-14. Spring и Mockito
    private final Map<Integer, List<Employee>> deptBook;

    public EmployeeServiceImpl() {
        this.deptBook = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentId) {

        String fName = EmployeeDataInput.checkName(firstName);
        String lName = EmployeeDataInput.checkName(lastName);

        Employee e = new Employee(fName, lName, salary, departmentId);
        List<Employee> employeeBook = new ArrayList<>();

        if (deptBook == null || !deptBook.containsKey(departmentId)) {
            employeeBook.add(e);
            deptBook.put(departmentId, employeeBook);
        } else {
            employeeBook = deptBook.get(departmentId);
            if (employeeBook != null && employeeBook.contains(e)) {
                throw new EmployeeAlreadyAddedException();
            } else {
                employeeBook.add(e);
                deptBook.put(departmentId, employeeBook);
            }
        }
        return e;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int departmentId) {

        String fName = EmployeeDataInput.checkName(firstName);
        String lName = EmployeeDataInput.checkName(lastName);

        Employee e = new Employee(fName, lName, salary, departmentId);
        List<Employee> employeeBook;

        if (deptBook == null || !deptBook.containsKey(departmentId)) {
            throw new EmployeeInputBadRequest();
        } else {
            employeeBook = deptBook.get(departmentId);
            if (employeeBook != null && employeeBook.contains(e)) {
                employeeBook.remove(e);
                deptBook.put(departmentId, employeeBook);
            } else {
                throw new EmployeeNotFoundException();
            }
        }
        return e;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int salary, int departmentId) {

        String fName = EmployeeDataInput.checkName(firstName);
        String lName = EmployeeDataInput.checkName(lastName);

        Employee e = new Employee(fName, lName, salary, departmentId);
        List<Employee> employeeBook;

        if (deptBook == null || !deptBook.containsKey(departmentId)) {
            throw new EmployeeInputBadRequest();
        } else {
            employeeBook = deptBook.get(departmentId);
            if (employeeBook == null || !employeeBook.contains(e)) {
                throw new EmployeeNotFoundException();
            } else
                return e;
        }
    }

    @Override
    public Map<Integer, List<Employee>> findAll() throws EmployeeNotFoundException {
        return Collections.unmodifiableMap(deptBook);
    }

}
