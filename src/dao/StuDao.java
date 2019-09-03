package dao;

import java.util.List;


import entity.Stu;

public interface StuDao {
	int addStu(Stu stu);
	int isStu(String studentno);
	Stu getStubyclassno(String classno);
	List<Stu> getStus();
	int updateStu(Stu stu);
	 int delStu(String studentno);
	 Stu getStubystudentno(String studentno);
}
