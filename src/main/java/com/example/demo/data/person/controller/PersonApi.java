//package com.example.demo.data.person.controller;
//
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.data.person.model.Person;
//import com.example.demo.data.person.service.PersonService;
//
//
//@RestController
//@RequestMapping(value = "/api/person")
//public class PersonApi {
//	private PersonService personService;
//
//	@Autowired
//	public PersonApi(PersonService personService) {
//		this.personService = personService;
//	}
//
//	@RequestMapping(value = {"/getAllUsers"},method = RequestMethod.GET)
//	public List<Person> getPersons(){
//		return personService.findAllPerson();
//	}
//
//	@RequestMapping(value =  {"/addUser"},method = RequestMethod.POST)
//	public Person Register(@RequestBody Person person) throws IOException, InvocationTargetException, IllegalAccessException {
//		return personService.registerPerson(person);
//	}
//
//
//	@RequestMapping(value = "/deleteUser/{id}" , method = RequestMethod.GET)
//	public void deletePersonById(Person person) {
//		personService.deleteById(person);
//	}
//
//	@RequestMapping(value = "/editUser/{id}" ,method = RequestMethod.GET )
//	public void editPersonByID(Model model,@PathVariable long id) {
//
//		//modelAndView.setViewName("redirect:/person/register");
//		//modelAndView.setViewName("PersonForm");
//		 personService.findById(id);
//
//	}
//
//
//}
//
//
//
//
//
//
