package edu.sjsu.cmpe275.lab2.service;

import java.util.List;

import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;;

public interface UserService {
	public void createUser(User user);
	public User getUser(int id);
	public String deleteUser(int id);
	public List<Phone> getPhones(int userId);
	public int getMaxId();
}
