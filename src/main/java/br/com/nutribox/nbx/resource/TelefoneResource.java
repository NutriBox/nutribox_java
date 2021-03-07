/**
 * 
 */
package br.com.nutribox.nbx.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.nutribox.nbx.entity.Telefone;
import br.com.nutribox.nbx.services.TelefoneService;

/**
 * @author edy
 *
 */
@Controller
@RequestMapping(value = "/telefones")
public class TelefoneResource {
	
	@Autowired
	private TelefoneService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Telefone>> obter(){
		List<Telefone> obj = service.obter();		
	    return ResponseEntity.ok().body(obj);
	} 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Telefone> obterId(@PathVariable Integer id) {
		Telefone obj = service.obterId(id);
		return ResponseEntity.ok().body(obj);
	} 

}
