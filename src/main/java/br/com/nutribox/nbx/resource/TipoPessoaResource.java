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

import br.com.nutribox.nbx.entity.TipoPessoa;
import br.com.nutribox.nbx.services.TipoPessoaService;

/**
 * @author edy
 *
 */
@Controller
@RequestMapping(value = "/tipo-pessoas")
public class TipoPessoaResource {

	@Autowired
	private TipoPessoaService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TipoPessoa>> obter(){
		List<TipoPessoa> obj = service.obter();		
	    return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TipoPessoa> obterId(@PathVariable Short id) {
		TipoPessoa obj = service.obterId(id);
		return ResponseEntity.ok().body(obj);
	} 
	
}
