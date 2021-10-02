package mvc_h_aop.controller;

import mvc_h_aop.entity.Employee;
import mvc_h_aop.exception_handling.EmployeIncorrectData;
import mvc_h_aop.exception_handling.NoSuchEmployeeException;
import mvc_h_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployes();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if(employee==null){
            throw new NoSuchEmployeeException(String.format("There is no employee with id: %d", id));
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee em = employeeService.getEmployee(id);
        if (em==null){
            throw new NoSuchEmployeeException("Not found =(");
        }
        String name = em.getName() + " " + em.getSurname();
        employeeService.deleteEmployee(id);
        return name + " was deleted successfully!";
    }

}
