package edu.sjsu.cmpe275.lab2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private PhoneService phoneService;
	
	@RequestMapping(method=RequestMethod.GET,value="",produces={"text/html"})
	public String getCreateUserView(){
		return "createUser";
	}
	//Request Mapping for create user
	@RequestMapping(method=RequestMethod.POST,value="/{id}",produces={"text/html"})
	public String createUser(@PathVariable int id,
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("title") String title,
			@RequestParam("street") String street,
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			@RequestParam("zip") String zip,			
			@RequestParam("phone[]") List<String> phone1,
			Model model,HttpServletResponse res){
		if(id!=0){
		String description="";		
		int phoneId=phoneService.getMaxId();
		Address address=null;
		List<Phone> phone=new ArrayList<Phone>();
		if(userService.getUser(id)!=null)
		{
		if(userService.getUser(id).getId()==id)
		{
		List<Phone> phones=(List<Phone>) userService.getPhones(id);
		address=new Address(street,city,state,zip);
		for(int i=0;i<phone1.size();i++)
		{
		Phone phone3=new Phone(phones.get(i).getId(),phone1.get(i),phones.get(i).getDescription(),address);
		phoneService.createPhone(phone3);	
		phone.add(phone3);	
		}
		}}
		else{
		System.out.println("Incremented phoneId: "+phoneId);
		address=new Address(street,city,state,zip);	
		id=userService.getMaxId();
		id++;
		for(String phone2 : phone1)
		{
		phoneId++;
		Phone phone3=new Phone(phoneId,phone2,description,address);
		System.out.println("Phone number is: "+phone2);
		phoneService.createPhone(phone3);
		phone.add(phone3);		
		}
		}
    	User user = new User(id,firstname,lastname,title,address,phone);
		userService.createUser(user);
		model.addAttribute("user",user);
		model.addAttribute("phone",phone);
		return "user";
		}
		else{
			String description="";		
			int phoneId=phoneService.getMaxId();
			Address address=null;
			List<Phone> phone=new ArrayList<Phone>();
			if(userService.getUser(id)!=null)
			{
			if(userService.getUser(id).getId()==id)
			{
			List<Phone> phones=(List<Phone>) userService.getPhones(id);
			address=new Address(street,city,state,zip);
			for(int i=0;i<phone1.size();i++)
			{
			Phone phone3=new Phone(phones.get(i).getId(),phone1.get(i),phones.get(i).getDescription(),address);
			phoneService.createPhone(phone3);	
			phone.add(phone3);	
			}
			}}
			else{
			System.out.println("Incremented phoneId: "+phoneId);
			address=new Address(street,city,state,zip);	
			id=userService.getMaxId();
			id++;
			for(String phone2 : phone1)
			{
			phoneId++;
			Phone phone3=new Phone(phoneId,phone2,description,address);
			System.out.println("Phone number is: "+phone2);
			phoneService.createPhone(phone3);
			phone.add(phone3);		
			}
			}
	    	User user = new User(id,firstname,lastname,title,address,phone);
			userService.createUser(user);
			model.addAttribute("id",id);
			return "newuser";
		}
	}
	
	//Request Mapping for delete user
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}",produces={"text/html"})
	@ResponseBody
	public String deleteUser(@PathVariable int id, Model model,HttpServletResponse res){
		
		res.addHeader("Access-Control-Allow-Methods", "HEAD, GET, POST, PUT, DELETE, OPTIONS");
		res.addHeader( "Access-Control-Allow-Origin", "*" );   
		List<Phone> phones=(List<Phone>) userService.getPhones(id);
		String isPhoneDeleted="false";
		String isUserDeleted="false";
		for(int i=0;i<phones.size();i++)
		{		
			isPhoneDeleted = phoneService.deletePhone(phones.get(i).getId());	
		}
		if(isPhoneDeleted=="true")
		{
			isUserDeleted = userService.deleteUser(id);
		}		
		if(isUserDeleted=="true")
			return "user";
		return "user/"+id;	
	}
	
	//Request Mapping for retrieving user
	@RequestMapping(method=RequestMethod.GET,value="/{id}",params={"!json"},produces={"text/html"})
	public String getUser(@PathVariable int id,Model model,HttpServletResponse res){
		User user = userService.getUser(id);
		List<Phone> phone=new ArrayList<Phone>();
		
		if(user==null){
			res.setStatus(404);
			model.addAttribute("id",id);
			model.addAttribute("res",res.getStatus());
			return "error";
		}else{
		List<Phone> phones=(List<Phone>) userService.getPhones(id);
		for(int i=0;i<phones.size();i++)
		{		
		phone.add(phones.get(i));	
		}}
		model.addAttribute(user);
		model.addAttribute("phone",phone);
		return "user";
	}
	//Request Mapping for retrieving user as JSON
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody String getUserasjson(@PathVariable int id,@RequestParam("json") String json,Model model,HttpServletResponse res){
		User user = userService.getUser(id);
		List<Phone> phone=new ArrayList<Phone>();
		if(user==null){
			res.setStatus(404);
			model.addAttribute("id",id);
			model.addAttribute("res",res.getStatus());
			return "error";
		}
		
		List<Phone> phones=(List<Phone>) userService.getPhones(id);
		for(int i=0;i<phones.size();i++)
		{		
		phone.add(phones.get(i));
		phones.get(i).setUsers(null);
		phones.get(i).setAddress(null);
		}
		user.setPhones(phones);
		System.out.println(user.getFirstname());
		System.out.println(user.getId());
		System.out.println(user.getLastname());
		System.out.println(user.getTitle());
		System.out.println(user.getAddress());
		for(int i=0;i<phones.size();i++)
		{		
			System.out.println(phones.get(i).getUsers());	
		}
		Gson gson = new Gson();
		return gson.toJson(user);		
	}

	
}
