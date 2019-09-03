package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entity.Employee;
import service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml","classpath:spring-mvc.xml"})          
public class EmployeeServiceTest {
		@Autowired
        private EmployeeService employeeService;
		
		@Test
		public void insertempTest() {
			Employee employee=new Employee();
			employee.setAge(22);
			employee.setSex(1);
			employee.setDeptid(2);
			employee.setUsername("李四");
			int i=employeeService.insertEmployee(employee);
			System.out.println(i);
		}
		
		@Test
		public void getEmpTest() {
			List<Employee> list=employeeService.getEmployees();
			for(Employee employee:list) {
				System.out.println(employee.getUsername());
			}
		}
		
		
}
