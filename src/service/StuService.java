package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StuDao;
import entity.Stu;

@Service
public class StuService {
		@Autowired
		private StuDao stuDao;
		public int insertStu(Stu stu) {
			int cnt=stuDao.isStu(stu.getStudentno());
	    	if(cnt>0){
				return -2;
			}
			int i= stuDao.addStu(stu);
			return i;
		}
		
		
		
		public Stu getStubyclassno(String classno) {
			return stuDao.getStubyclassno(classno);
		}
		
		public Stu getStubystudentno(String studentno) {
			return stuDao.getStubystudentno(studentno);
		}
		
		public List<Stu> getStus() {
			return stuDao.getStus();
		}
		
		public int updateStu(Stu stu) {
			return stuDao.updateStu(stu);
		}
		
		public int delStu(String studentno) {
			return stuDao.delStu(studentno);
		}
}
