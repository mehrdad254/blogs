package com.example.demo.data.person.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.person.model.Person;
import com.example.demo.data.person.service.PersonService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

//	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView timing(ModelAndView theModel,@PageableDefault(size = 6) Pageable pageable) {
		theModel.addObject("persons", personService.findAllPerson(pageable));
		theModel.setViewName("person/Person-Manage");
		return theModel;
	}

	@GetMapping(value = "/register")
	public ModelAndView RegisterPage(ModelAndView theModel) {
		theModel.addObject("person", new Person());
		theModel.setViewName("person/PersonEdit");
		return theModel;
	}

	@PostMapping("/register")
	public ModelAndView Register(@RequestBody @ModelAttribute Person person, ModelAndView theModel) throws IOException, InvocationTargetException, IllegalAccessException {
		personService.registerPerson(person);
		theModel.setViewName("redirect:/person/list");
		return theModel;
	}
	
	@GetMapping(value = "/edit/{id}")
	public ModelAndView editPerson(ModelAndView model, @PathVariable("id") Long id) {
		model.addObject("person", personService.findById(id));
		model.setViewName("/person/PersonEdit");
		return model;
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public ModelAndView deletePersonById(Person person, ModelAndView modelAndView) {
		personService.deleteById(person);
		modelAndView.setViewName("redirect:/person/list");
		return modelAndView;
	}
}
