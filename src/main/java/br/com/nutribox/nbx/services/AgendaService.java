package br.com.nutribox.nbx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.nutribox.nbx.dto.AgendaDTO;
import br.com.nutribox.nbx.entity.Agenda;
import br.com.nutribox.nbx.repositories.AgendaRepository;
import br.com.nutribox.nbx.services.exceptions.DataIntegrityException;
import br.com.nutribox.nbx.services.exceptions.ObjectNotFoundException;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repo;

	public Agenda find(Long id) {
		Optional<Agenda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + " tipo: " + Agenda.class.getName()));
	}

	public List<Agenda> findAll() {
		return repo.findAll();
	}

	public Page<Agenda> findAllPage(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Agenda insert(Agenda obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Agenda update(Agenda obj) {
		Agenda newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Agenda newObj, Agenda obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setStart(obj.getStart());
		newObj.setEnd(obj.getEnd());
		newObj.setAllDay(obj.getAllDay());
		newObj.setBackgroundColor(obj.getBackgroundColor());
	}

	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir o agedamento existe porqeue existe dependências");
		}

	}

	public Agenda fromDTO(AgendaDTO objDTO) {
		return new Agenda(
				objDTO.getId(), 
				objDTO.getTitle(), 
				objDTO.getStart(), 
				objDTO.getEnd(), 
				objDTO.getAllDay(),
				objDTO.getBackgroundColor());
	}

}
