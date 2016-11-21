package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;


public interface PhoneDao {
	public void createPhone(Phone phone);
	public Phone getPhone(int id);
	public void deletePhone(Phone phone);
	public int getMaxId();
	public List<User> getUsers(int phId);
}

