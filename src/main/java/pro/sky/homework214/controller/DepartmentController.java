package pro.sky.homework214.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homework214.repository.Employee;
import pro.sky.homework214.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> findAllEmployeeAllDept() {
        return departmentService.findAllEmployeesFromAllDepartments();
    }

    @GetMapping(path = "/{deptId}/employees")
    public List<Employee> findEmployeeDept(@PathVariable String deptId) {
        return departmentService.findAllEmployeesFromDepartment(Integer.parseInt(deptId));
    }

    @GetMapping(path = "/{deptId}/salary/sum")
    public int countSumSalaryFromDept(@PathVariable String deptId) {
        return departmentService.countSumSalaryFromDepartment(Integer.parseInt(deptId));
    }

    @GetMapping(path = "/{deptId}/salary/max")
    public int findMaxSalaryFromDept(@PathVariable String deptId) {
        return departmentService.findMaxSalaryFromDepartment(Integer.parseInt(deptId));
    }

    @GetMapping(path = "/{deptId}/salary/min")
    public int findMinSalaryFromDept(@PathVariable String deptId) {
        return departmentService.findMinSalaryFromDepartment(Integer.parseInt(deptId));
    }

}
