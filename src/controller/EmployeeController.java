package controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.DepartmentService;
import service.EmployeeService;
import service.Login;
import entity.Department;
import entity.Employee;
import entity.Result;
import entity.User;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private Login login;
	
	   @RequestMapping("/add")
       public ModelAndView add() {
		   List<Department> depts=departmentService.getDepts();
			ModelAndView mv=new ModelAndView("employee/add");
			mv.addObject("depts", depts);
			return mv;
       }
	   
	   @RequestMapping("/list")
	   public ModelAndView list() {
		   List<Employee> employees=employeeService.getEmployees();
		   ModelAndView mv=new ModelAndView("employee/list");
		   mv.addObject("employees", employees);
		   return mv;
	   }
	  
	   
	   @RequestMapping("/login")
	    public ModelAndView login() {
		   ModelAndView mv=new ModelAndView("employee/login");
    	   return mv;
	    }
	   
	   @RequestMapping("/add_submit")
	   @ResponseBody
	   public Result add_submit(String username,Integer sex,Integer age,Integer deptid) {
		 Employee employee=new Employee();
		 employee.setUsername(username);
		 employee.setSex(sex);
		 employee.setAge(age);
		 employee.setDeptid(deptid);
		 int i=employeeService.insertEmployee(employee);
		 if(i>0) {
			 return new Result(1,"新增成功");
		 }else if(i==-2){
			 return new Result(2,"该用户已存在");
		} else {
			 return new Result(0,"新增失败");
		}
	   }
	   
	   @RequestMapping("/del")
	   @ResponseBody
	   public Result del(String username) {
		   int i=employeeService.delEmployee(username);
		   if(i>0) {
			   return new Result(1, "删除成功");
		   }else {
			   return new Result(0, "删除失败");
		   }
	   }
	   
	   @RequestMapping("/update")
		public ModelAndView edit(String username){
		   List<Department> depts=departmentService.getDepts();
			ModelAndView mv=new ModelAndView("employee/update");
			Employee employee=employeeService.getEmployeeByUsername(username);
			mv.addObject("depts", depts);
			mv.addObject("employee", employee);
			return mv;
		}
	   
	   @RequestMapping("/login_submit")
		public String login_submit(Model model,User user)  throws IOException {
			model.addAttribute("user", user);
			boolean isLogin=login.login(user.getUsername(), user.getPassword());
			if(isLogin) {
				return "employee/login_success";
			}else {
				return "employee/login_fail";
			}
		}
	   
	   @RequestMapping("/update_submit")
		@ResponseBody
		public Result update_submit(Employee employee){
			//修改雇员
			int i=employeeService.updateEmp(employee);
			if(i>0){
				return new Result(1,"修改雇员成功");
			}else{
				return new Result(0,"修改雇员失败");
			}
		}
	}


