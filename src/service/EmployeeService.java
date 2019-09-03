package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import dao.EmployeeDao;
import entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
      public int insertEmployee(Employee employee) {
    	int cnt=employeeDao.isEmployee(employee.getUsername());
    	if(cnt>0){
			return -2;
		}
		int i= employeeDao.addEmployee(employee);
		return i;
	}
      public List<Employee> getEmployees(){
  		return employeeDao.getEmployees();
  	} 
      
      public int delEmployee(String username) {
    	  return employeeDao.delEmployee(username);
      }
      
      public Employee getEmployeeByUsername(String username){
  		return employeeDao.getEmployeeByUsername(username);
  	}
      
      public int updateEmp(Employee employee){
  		return employeeDao.updateEmp(employee);
  	}
      
      @Transactional
      public void addEmployees(List<Employee> employees) {
    	  int i=0;
    	  for(Employee employee:employees) {
    		  if(i==2) {
    			  int k=1/0;
    		  }
    		  this.insertEmployee(employee);
    		  i++;
    	  }
      }
}
