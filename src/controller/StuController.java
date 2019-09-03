package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Result;
import entity.Stu;
import service.StuService;

@Controller
@RequestMapping("/stu")
public class StuController {
 @Autowired
 private StuService stuService;
 
 @RequestMapping("/addstu")
public ModelAndView addstu() {
	 ModelAndView mv=new ModelAndView("stu/addstu");
	 return mv;
 }
 
 
 @RequestMapping("/stulist")
 public ModelAndView list() {
	   List<Stu> stus=stuService.getStus();
	   ModelAndView mv=new ModelAndView("stu/stulist");
	   mv.addObject("stus", stus);
	   return mv;
 }
 
 @RequestMapping("/add_submit")
 @ResponseBody
 public Result add_submit(String studentno,String username,Integer sex,Integer age,String classno) {
	 Stu stu=new Stu();
	 stu.setStudentno(studentno);
	 stu.setUsername(username);
	 stu.setSex(sex);
	 stu.setAge(age);
	 stu.setClassno(classno);
	 int i=stuService.insertStu(stu);
	 if(i>0) {
		 return new Result(1,"新增成功");
	 }else if(i==-2){
		 return new Result(2,"该学生已存在");
	} else {
		 return new Result(0,"新增失败");
	}
 }
 
 @RequestMapping("/update")
		public ModelAndView edit(String studentno){
			ModelAndView mv=new ModelAndView("stu/updatestu");
			Stu stu=stuService.getStubystudentno(studentno);
			mv.addObject("stu", stu);
			return mv;
		}
 
        @RequestMapping("/update_submit")
		@ResponseBody
		public Result update_submit(Stu stu){
			//修改雇员
			int i=stuService.updateStu(stu);
			if(i>0){
				return new Result(1,"修改学生成功");
			}else{
				return new Result(0,"修改学生失败");
			}
		}
 
 @RequestMapping("/del")
 @ResponseBody
 public Result del(String studentno) {
	   int i=stuService.delStu(studentno);
	   if(i>0) {
		   return new Result(1, "删除成功");
	   }else {
		   return new Result(0, "删除失败");
	   }
 }
 
}
