package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;

public interface UserDao {
	public void createUser(User user);
	public User getUser(int id);
	public void deleteUser(User user);
	public List<Phone> getPhones(int userId);
	public int getMaxId();
}
