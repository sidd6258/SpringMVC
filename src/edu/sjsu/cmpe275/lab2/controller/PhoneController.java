package edu.sjsu.cmpe275.lab2.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;
import edu.sjsu.cmpe275.lab2.service.PhoneService;
import edu.sjsu.cmpe275.lab2.service.UserService;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	@Autowired
	private PhoneService phoneService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET,value="",produces={"text/html"})
	public String getCreatePhoneView(){
		return "createPhone";
	}	//Request Mapping for create phone
	@RequestMapping(method=RequestMethod.POST,value="/{id}",params={"!userid","!removebutton","!adduser"},produces={"text/html"})
	public String createPhone(@PathVariable int id,
			@RequestParam("number") String number,
			@RequestParam("description") String description,
			@RequestParam("street") String street,
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			@RequestParam("zip") String zip,			
			Model model){
		Address address=new Address(street,city,state,zip);
		Phone phone= new Phone(id,number,description,address);
		if(phoneService.getPhone(id)!=null)
		{
		phone=phoneService.getPhone(id);
		phone.setAddress(address);
		phone.setDescription(description);
		phone.setNumber(number);
		}		
		phoneService.createPhone(phone);
		model.addAttribute("phone",phone);
		model.addAttribute("address",address);
		return "phone";

	}
	//Request Mapping for delete phone
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}",produces={"text/html"})
	@ResponseBody
	public String deletePhone(@PathVariable int id, Model model,HttpServletResponse res){
		
		res.addHeader("Access-Control-Allow-Methods", "HEAD, GET, POST, PUT, DELETE, OPTIONS");
		res.addHeader( "Access-Control-Allow-Origin", "*" );   
		String isPhoneDeleted = phoneService.deletePhone(id);
		if(isPhoneDeleted=="true")
			return "phone";
		return "phone"+id;	
	}
	@RequestMapping(method=RequestMethod.GET,value="/{id}",params={"!json"},produces={"text/html"})
	public String getPhone(@PathVariable int id,Model model,HttpServletResponse res){
		Phone phone = phoneService.getPhone(id);
		List<User> user = new ArrayList<User>();
		Address address=null;
		if(phone==null){
			res.setStatus(404);
			model.addAttribute("id",id);
			model.addAttribute("res",res.getStatus());
			return "error";
		}
		else{
			List<User> users = (List<User>) phoneService.getUsers(id);
			for(int i=0;i<users.size();i++)
			{		
			user.add(users.get(i));
			users.get(i).setPhones(null);
			}
			
		}
		Gson gson=new Gson();
		address=new Address(phone.getAddress().getStreet(),phone.getAddress().getCity(),phone.getAddress().getState(),phone.getAddress().getZip());
		model.addAttribute("phone",phone);
		model.addAttribute("address",address);
		model.addAttribute("user",user);
		return "phone";
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody String getPhoneasjson(@PathVariable int id,@RequestParam("json") String json,Model model,HttpServletResponse res){
		Phone phone = phoneService.getPhone(id);
		List<User> user = new ArrayList<User>();
		Address address=null;
		if(phone==null){
			res.setStatus(404);
			model.addAttribute("id",id);
			model.addAttribute("res",res.getStatus());
			return "error";
		}
		else{
			List<User> users = (List<User>) phoneService.getUsers(id);
			for(int i=0;i<users.size();i++)
			{		
			user.add(users.get(i));
			users.get(i).setPhones(null);
			users.get(i).setAddress(null);
			users.get(i).setTitle(null);
			}
			phone.setUsers(users);
		}
		Gson gson=new Gson();
		System.out.println(gson.toJson(phone));
		return gson.toJson(phone);
	}
	@RequestMapping(method=RequestMethod.POST,value="/{id}",params={"!removebutton","!adduser"},produces={"text/html"})
	public String addUser(
			@RequestParam("id") int id,
			@RequestParam("userid") int userId,
			Model model,HttpServletResponse res){
		res.addHeader("Access-Control-Allow-Methods", "HEAD, GET, POST, PUT, DELETE, OPTIONS");
		res.addHeader( "Access-Control-Allow-Origin", "*" );   
		Phone phone = phoneService.getPhone(id);
		List<User> users = new ArrayList<User>();
		User user = userService.getUser(userId);
		if(user==null)
		{
			res.setStatus(404);
			return "error";
		}
		else{
		users=phoneService.getUsers(id);
		users.add(user);
		Phone phone1=new Phone(phone.getId(),phone.getNumber(),phone.getDescription(),phone.getAddress(),users);
		phoneService.createPhone(phone1);
		model.addAttribute("phone",phone1);
		model.addAttribute("address",phone1.getAddress());
		return "phone";
		}
	}
	@RequestMapping(method=RequestMethod.POST,value="/{id}",params={"!userid","!adduser"},produces={"text/html"})
	public String removeUser(
			@RequestParam("id") int id,
			@RequestParam("removebutton") int userId,
			Model model){
		Phone phone = phoneService.getPhone(id);
		ArrayList<User> users = new ArrayList<User>();
		User user = userService.getUser(userId);
		users=(ArrayList<User>) phoneService.getUsers(id);
		for(int i=0;i<users.size();i++)
	    {
	           User user1=((User)users.get(i));  
	                if(user1.getId() == userId) //checks with overrided equals method of MyModel 
	                    users.remove(i);  
	                }
		Phone phone1=new Phone(phone.getId(),phone.getNumber(),phone.getDescription(),phone.getAddress(),users);
		phoneService.createPhone(phone1);
		model.addAttribute("phone",phone1);
		model.addAttribute("address",phone1.getAddress());
		return "phone";

	}
	@RequestMapping(method=RequestMethod.POST,value="/{id}",produces={"text/html"})
	public String addUserView(
			@RequestParam("id") int id,
			Model model){
		model.addAttribute("id",id);
		return "addUser";

	}
}
