package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.UserDao;
import entity.User;
@Service
public class Login {
	@Autowired
	private UserDao userDao;
	public boolean login(String username,String password){
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		User u= userDao.getUser(user);
		if(u!=null){
			return true;
		}
		return false;
	}
}
