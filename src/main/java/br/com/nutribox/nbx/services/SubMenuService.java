package br.com.nutribox.nbx.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.nutribox.nbx.dto.SubMenuDTO;
import br.com.nutribox.nbx.entity.SubMenu;
import br.com.nutribox.nbx.repositories.SubMenuRepositories;
import br.com.nutribox.nbx.services.exceptions.DataIntegrityException;
import br.com.nutribox.nbx.services.exceptions.ObjectNotFoundException;

@Service
public class SubMenuService {

	@Autowired
	private SubMenuRepositories repo;
	
	public SubMenu find(Integer id) {
		  Optional<SubMenu> obj =  repo.findById(id);
		  return obj.orElseThrow(()-> new ObjectNotFoundException(
				  "Objeto não encontrado Id: " + id + " tipo: " + SubMenu.class.getName()
				  ));
		}
	public List <SubMenu> findAll() {
        return repo.findAll();
    }
	
	public Page<SubMenu> findAllPage(Pageable pageable) {		
		return repo.findAll(pageable);
	}
	
	
	public SubMenu insert(SubMenu obj) {
		obj.setIdSubMenu(null);
		return repo.save(obj);
	}

	public SubMenu update(SubMenu obj) {
		SubMenu newObj = find(obj.getIdSubMenu());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
		
	private void updateData(SubMenu newObj, SubMenu obj) {
		newObj.setDescSubMenu(obj.getDescSubMenu());
		newObj.setIcone(obj.getIcone());
		newObj.setIdSubMenu(obj.getIdSubMenu());
		newObj.setLink(obj.getLink());
		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir! O sub menu está sendo usada pelo sistema!");
		}
		
    }
	
	
	//Metodo auxiliar para converte DTO
	public SubMenu fromDTO(@Valid SubMenuDTO objDTO) {
		return new SubMenu( 
				objDTO.getIdSubMenu(), 
				objDTO.getDescSubMenu(),
				objDTO.getIcone(),
				objDTO.getLink(),
				objDTO.getActive(),
				objDTO.getMenu()
				);
	}

}
