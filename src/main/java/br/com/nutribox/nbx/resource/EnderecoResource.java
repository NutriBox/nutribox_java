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

import br.com.nutribox.nbx.entity.Endereco;
import br.com.nutribox.nbx.services.EnderecoService;

/**
 * @author edy
 *
 */
@Controller
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
		
		@Autowired
		private EnderecoService service;
		
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<Endereco>> obter(){
			List<Endereco> obj = service.obter();		
		    return ResponseEntity.ok().body(obj);
		} 
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Endereco> obterId(@PathVariable Integer id) {
			Endereco obj = service.obterId(id);	
			return ResponseEntity.ok().body(obj);
		} 

}
