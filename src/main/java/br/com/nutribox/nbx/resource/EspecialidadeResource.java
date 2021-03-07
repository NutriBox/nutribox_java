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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nutribox.nbx.dto.EspecialidadeDTO;
import br.com.nutribox.nbx.entity.Especialidade;
import br.com.nutribox.nbx.services.EspecialidadeService;

/**
 * @author edy
 *
 */
@RestController
@RequestMapping(value = "/especialidades")
public class EspecialidadeResource {
	
	@Autowired	
	private EspecialidadeService service;
	
	@CrossOrigin	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EspecialidadeDTO>> findAll( ) {		
		List<Especialidade> list = service.findAll();	
		List<EspecialidadeDTO> listDTO =
				list.stream()
				.map(obj -> new EspecialidadeDTO(obj))
				.collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDTO);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Especialidade> findById(@PathVariable Integer id ) {		
		Especialidade obj = service.find(id);		
	    return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EspecialidadeDTO objDTO){
		Especialidade obj = service.fromDTO(objDTO);
		obj =  service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getIdEspecialidade())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updade(@Valid @RequestBody EspecialidadeDTO objDTO, @PathVariable Integer id){
		Especialidade obj = service.fromDTO(objDTO);
		obj.setIdEspecialidade(id);	
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
	public ResponseEntity<Page<EspecialidadeDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="idEspecialidade") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Especialidade> list = service.obterPorPagina(page, linesPerPage, direction, orderBy);	
		Page<EspecialidadeDTO> listDto = list.map(obj -> new EspecialidadeDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}
