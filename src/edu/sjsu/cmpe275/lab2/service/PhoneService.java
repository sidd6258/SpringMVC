package edu.sjsu.cmpe275.lab2.service;

import java.util.List;
import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;


public interface PhoneService {
	public void createPhone(Phone phone);
	public Phone getPhone(int id);
	public String deletePhone(int id);
	public int getMaxId();
	public List<User> getUsers(int phId);
}
