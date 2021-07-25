package br.com.nutribox.nbx.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nutribox.nbx.dto.AgendaDTO;
import br.com.nutribox.nbx.entity.Agenda;
import br.com.nutribox.nbx.services.AgendaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api/agendas")
public class AgendaResource {

	@Autowired
	private AgendaService service;
	
	@CrossOrigin	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> findAll() {		
		List<Agenda> list = service.findAll();	
		List<AgendaDTO> listDTO =
				list.stream()
				.map(obj -> new AgendaDTO(obj))
				.collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDTO);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agenda> findById(@PathVariable Long id ) {		
		Agenda obj = service.find(id);		
	    return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AgendaDTO objDTO){
		Agenda obj = service.fromDTO(objDTO);
		obj =  service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updade(@Valid @RequestBody AgendaDTO objDTO, @PathVariable Long id){
		Agenda obj = service.fromDTO(objDTO);
		obj.setId(id);	
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
			service.delete(id);
			return ResponseEntity.noContent().build();
	}
	
}
