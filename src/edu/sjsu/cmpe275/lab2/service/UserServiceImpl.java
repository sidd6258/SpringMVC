package edu.sjsu.cmpe275.lab2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.sjsu.cmpe275.lab2.dao.UserDao;
import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;

/**
 * service - transactional
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	//create profile service method
	public void createUser(User user) {
		userDao.createUser(user);
	}

	//get profile service method
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	//delete profile service method
	public String deleteUser(int id) {
		
		//getting the profile of the person to be deleted
		User user = userDao.getUser(id);
		if(user == null){
			return "false";
		}
		
		userDao.deleteUser(user);
		return "true";
	}
	public List<Phone> getPhones(int userId){
		return userDao.getPhones(userId);
	}
	public int getMaxId() {		 
		return userDao.getMaxId();
	}
}