package edu.sjsu.cmpe275.lab2;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

@RequestMapping(value="/admissionForm.html",method=RequestMethod.GET)	
public ModelAndView getAdmissionForm(@PathVariable Map<String,String> pathVar){
	
	ModelAndView model=new ModelAndView("AdmissionForm");
	return model;
}
@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)	
public ModelAndView submitAdmissionForm(@ModelAttribute("student1") Student student1)
{	

	ModelAndView model=new ModelAndView("SubmitAdmissionForm");
	model.addObject("msg","Siddharth college of engineering");
	return model;
}
}
