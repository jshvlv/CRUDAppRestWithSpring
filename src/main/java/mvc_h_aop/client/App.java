package mvc_h_aop.client;

import mvc_h_aop.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ClientConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
//        List<Employee> emps = communication.getAllEmployees();
//        System.out.println(emps);
//
//        System.out.println(".................");
//
//        Employee empById = communication.getEmployee(29);
//        System.out.println(empById);
//        Employee employee = new Employee("Sveta", "Sokolova", "HR", 1);
//        employee.setId(30);
//        communication.saveEmployee(employee);
        communication.deleteEmployee(30);
    }
}
