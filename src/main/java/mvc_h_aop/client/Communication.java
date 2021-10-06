package mvc_h_aop.client;

import mvc_h_aop.entity.Employee;
import mvc_h_aop.exception_handling.NoSuchEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL="http://localhost:8080/api/employees";

    public List<Employee> getAllEmployees(){
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
                });
        List<Employee> employees = responseEntity.getBody();

        return employees;
    }

    public Employee getEmployee(int id){
        Employee employee = restTemplate.getForObject(URL+"/"+id, Employee.class);

        return employee;
    }

    public void saveEmployee(Employee employee){
        int id = employee.getId();
        if(id==0){
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("new Employee was added...");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println(employee.getName() + " was updated");
        }
    }

    public void deleteEmployee(int id){
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with id " + id + " was deleted");
    }
}
