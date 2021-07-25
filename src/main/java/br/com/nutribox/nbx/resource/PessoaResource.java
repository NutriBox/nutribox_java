/**
 * 
 */
package br.com.nutribox.nbx.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nutribox.nbx.dto.PessoaDTO;
import br.com.nutribox.nbx.entity.Pessoa;
import br.com.nutribox.nbx.services.PessoaService;

/**
 * @author edy
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	/*
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET) public
	 * ResponseEntity<Pessoa> obterId(@PathVariable Integer id) { Pessoa obj =
	 * service.obterId(id); return ResponseEntity.ok().body(obj); }
	 */
	
	@CrossOrigin	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> findAll( ) {		
		List<Pessoa> list = service.findAll();	
		List<PessoaDTO> listDTO =
				list.stream()
				.map(obj -> new PessoaDTO(obj))
				.collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDTO);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pessoa> findById(@PathVariable Integer id ) {		
		Pessoa obj = service.find(id);		
	    return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PessoaDTO objDTO){
		Pessoa obj = service.fromDTO(objDTO);
		obj =  service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getIdPessoa())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updade(@Valid @RequestBody PessoaDTO objDTO, @PathVariable Integer id){
		Pessoa obj = service.fromDTO(objDTO);
		obj.setIdPessoa(id);	
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
			service.delete(id);
			return ResponseEntity.noContent().build();
	}
	

	@CrossOrigin
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<PessoaDTO>> findPage(Pageable pageable) {
		Page<Pessoa> list = service.findAllPage(pageable);	
		Page<PessoaDTO> listDto = list.map(obj -> new PessoaDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
}
