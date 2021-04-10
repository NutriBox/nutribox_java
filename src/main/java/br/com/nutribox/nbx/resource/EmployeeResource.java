package br.com.nutribox.nbx.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EmployeeResource {

	 @RequestMapping(value = "/greeting", method = RequestMethod.GET)
	    public String getEmployees() {
	        return "Bem vindo!";
	    }
	
}
