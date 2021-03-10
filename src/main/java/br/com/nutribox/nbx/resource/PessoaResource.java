/**
 * 
 */
package br.com.nutribox.nbx.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.nutribox.nbx.entity.Pessoa;
import br.com.nutribox.nbx.services.PessoaService;

/**
 * @author edy
 *
 */
@Controller
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pessoa> obterId(@PathVariable Integer id) {
		Pessoa obj = service.obterId(id);
		return ResponseEntity.ok().body(obj);
	} 
	

}
