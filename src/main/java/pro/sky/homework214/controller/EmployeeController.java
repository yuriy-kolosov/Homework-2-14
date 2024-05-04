package pro.sky.homework214.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework214.repository.Employee;
import pro.sky.homework214.service.EmployeeService;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String fName,
                                @RequestParam("lastName") String lName,
                                @RequestParam("salary") int salary,
                                @RequestParam("departmentId") int deptId) {
        return employeeService.addEmployee(fName, lName, salary, deptId);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String fName,
                                 @RequestParam("lastName") String lName,
                                 @RequestParam("salary") int salary,
                                 @RequestParam("departmentId") int deptId) {
        return employeeService.findEmployee(fName, lName, salary, deptId);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String fName,
                                   @RequestParam("lastName") String lName,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("departmentId") int deptId) {
        return employeeService.removeEmployee(fName, lName, salary, deptId);
    }

}
