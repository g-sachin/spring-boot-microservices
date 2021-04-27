package com.sachin.rest.webservices.springbootwebservice.controller;

import java.time.Instant;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
// How bean converted to JSON Object
//Underneath the hood of Spring boot web starter , 
//there is a Json parser called Jackson. Jackson will convert the bean into JSON.
	
//https://spring.io/guides/gs/rest-service/
//https://zetcode.com/springboot/json/
	
	//O/P: whoo sample done
	@GetMapping(path="/test")
	public String foo() {
		return "whoo sample done";
	}
	
	
	// O/P: {"template":"Bean example"}
	@GetMapping(path="/test-bean")
	public FooBean fooBean() {
		return new FooBean("Bean example", Date.from(Instant.now()), new NestedBean("nested"));
	}
	
	
	//O/P:  {"template":"Bean Path Variable Example: sachin"}
	@GetMapping(path="/test-bean/path-variable/{random}")
	public FooBean fooBeanPathVairableExample(@PathVariable String random) {
		return new FooBean("Bean Path Variable Example: "+random, null, null);
	}
}

 	
class FooBean {
	private String template;
	private Date date;
	private NestedBean nes;
	
	public FooBean(String template, Date date, NestedBean nes) {
		this.template = template;
		this.date = date;
		this.nes = nes;
	}
	
	public String getTemplate() {
		return template;
	}
	
	public Date getDate() {
		return date;
	}

	public NestedBean getNestedBean() {
		return nes;
	}
	@Override
	public String toString() {
		return "FooBean [template=" + template + "]";
	}
}

class NestedBean { 
	private String nested;
	
	public NestedBean(String ex) {
		this.nested =ex;
	}
	
	public String getNested() {
		return nested;
	}
}