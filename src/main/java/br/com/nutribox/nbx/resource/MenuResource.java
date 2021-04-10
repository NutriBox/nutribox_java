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

import br.com.nutribox.nbx.dto.MenuDTO;
import br.com.nutribox.nbx.entity.Menu;
import br.com.nutribox.nbx.services.MenuService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/menus")
public class MenuResource {
	
	@Autowired
	private MenuService service;

	@CrossOrigin	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MenuDTO>> findAll( ) {		
		List<Menu> list = service.findAll();	
		List<MenuDTO> listDTO =
				list.stream()
				.map(obj -> new MenuDTO(obj))
				.collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDTO);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Menu> findById(@PathVariable Integer id ) {		
		Menu obj = service.find(id);		
	    return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MenuDTO objDTO){
		Menu obj = service.fromDTO(objDTO);
		obj =  service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getIdMenu())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updade(@Valid @RequestBody MenuDTO objDTO, @PathVariable Integer id){
		Menu obj = service.fromDTO(objDTO);
		obj.setIdMenu(id);	
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
	public ResponseEntity<Page<MenuDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="idMenu") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Menu> list = service.obterPorPagina(page, linesPerPage, direction, orderBy);	
		Page<MenuDTO> listDto = list.map(obj -> new MenuDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}
