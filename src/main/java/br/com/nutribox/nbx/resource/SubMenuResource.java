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

import br.com.nutribox.nbx.dto.SubMenuDTO;
import br.com.nutribox.nbx.entity.SubMenu;
import br.com.nutribox.nbx.services.SubMenuService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/submenus")
public class SubMenuResource {

	@Autowired
	private SubMenuService service;

	@CrossOrigin	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SubMenuDTO>> findAll( ) {		
		List<SubMenu> list = service.findAll();	
		List<SubMenuDTO> listDTO =
				list.stream()
				.map(obj -> new SubMenuDTO(obj))
				.collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDTO);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<SubMenu> findById(@PathVariable Integer id ) {		
		SubMenu obj = service.find(id);		
	    return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SubMenuDTO objDTO){
		SubMenu obj = service.fromDTO(objDTO);
		obj =  service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getIdSubMenu())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updade(@Valid @RequestBody SubMenuDTO objDTO, @PathVariable Integer id){
		SubMenu obj = service.fromDTO(objDTO);
		obj.setIdSubMenu(id);	
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
	public ResponseEntity<Page<SubMenuDTO>> findPage(Pageable pageable) {
		Page<SubMenu> list = service.findAllPage(pageable);	
		Page<SubMenuDTO> listDto = list.map(obj -> new SubMenuDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
}
