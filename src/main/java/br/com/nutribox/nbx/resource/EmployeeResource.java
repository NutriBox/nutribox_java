package br.com.nutribox.nbx.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/version")
public class EmployeeResource {

	@RequestMapping(method = RequestMethod.GET)
	    public String getEmployees() {
	        return "Nutribox vs 1.0.0.1";
	    }
	
}
