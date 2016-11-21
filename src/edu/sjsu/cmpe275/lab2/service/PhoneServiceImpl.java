package edu.sjsu.cmpe275.lab2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.dao.PhoneDao;
import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;

/**
 * service - transactional
 *
 */

@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneDao phoneDao;

	//create profile service method
	public void createPhone(Phone phone) {
		phoneDao.createPhone(phone);
	}

	//get profile service method
	public Phone getPhone(int id) {
		return phoneDao.getPhone(id);
	}

	//delete profile service method
	public String deletePhone(int id) {
		
		//getting the profile of the person to be deleted
		Phone phone = phoneDao.getPhone(id);
		if(phone == null){
			return "false";
		}
		
		phoneDao.deletePhone(phone);
		return "true";
	}
	public int getMaxId() {		 
		return phoneDao.getMaxId();
	}
	public List<User> getUsers(int phId) {
		return phoneDao.getUsers(phId);
	}
}