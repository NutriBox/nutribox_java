package br.com.nutribox.nbx.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.nutribox.nbx.dto.MenuDTO;
import br.com.nutribox.nbx.entity.Menu;
import br.com.nutribox.nbx.repositories.MenuRepository;
import br.com.nutribox.nbx.services.exceptions.DataIntegrityException;
import br.com.nutribox.nbx.services.exceptions.ObjectNotFoundException;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository repo;
	
	public Menu find(Integer id) {
		  Optional<Menu> obj =  repo.findById(id);
		  return obj.orElseThrow(()-> new ObjectNotFoundException(
				  "Objeto não encontrado Id: " + id + " tipo: " + Menu.class.getName()
				  ));
		}
		
		public List <Menu> findAll() {
	        return repo.findAll();
	    }
		
		public Menu insert(Menu obj) {
			obj.setIdMenu(null);
			return repo.save(obj);
		}

		public Menu update(Menu obj) {
			Menu newObj = find(obj.getIdMenu());
			updateData(newObj, obj);
			return repo.save(newObj);
		}
			
		private void updateData(Menu newObj, Menu obj) {
			newObj.setDescGroup(obj.getDescGroup());
			newObj.setIcone(obj.getIcone());
			newObj.setIdMenu(obj.getIdMenu());
			newObj.setLink(obj.getLink());
		}

		public void delete(Integer id) {
			find(id);
			try {
				repo.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir! O menu está sendo usada pelo sistema!");
			}
			
	    }
		
		public Page<Menu> obterPorPagina(Integer page, Integer linesPerPage, String direction, String orderBy) {
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			return repo.findAll(pageRequest);
		}	
		
		//Metodo auxiliar para converte DTO
		public Menu fromDTO(@Valid MenuDTO objDTO) {
			return new Menu( 
					objDTO.getIdMenu(), 
					objDTO.getDescGroup(),
					objDTO.getIcone(),
					objDTO.getLink(),					
					objDTO.getActive()
					);
		}

}
