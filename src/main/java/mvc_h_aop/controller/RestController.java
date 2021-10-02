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

    @ExceptionHandler
    public ResponseEntity<EmployeIncorrectData> handleException(NoSuchEmployeeException noSuchEmployeeException){
        EmployeIncorrectData  data = new EmployeIncorrectData();
        data.setInfo(noSuchEmployeeException.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeIncorrectData> handleException(Exception exception){
        EmployeIncorrectData  data = new EmployeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
