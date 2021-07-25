package br.com.nutribox.nbx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.nutribox.nbx.dto.PessoaDTO;
import br.com.nutribox.nbx.entity.Pessoa;
import br.com.nutribox.nbx.repositories.PessoaRepository;
import br.com.nutribox.nbx.services.exceptions.DataIntegrityException;
import br.com.nutribox.nbx.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	
	
	public Pessoa find(Integer id) {
		  Optional<Pessoa> obj =  repo.findById(id);
		  return obj.orElseThrow(()-> new ObjectNotFoundException(
				  "Objeto não encontrado Id: " + id + " tipo: " + Pessoa.class.getName()
				  ));
		}
		
		public List <Pessoa> findAll() {
	        return repo.findAll();
	    }
		
		public Page<Pessoa> findAllPage(Pageable pageable) {			
			return repo.findAll(pageable);
		}

		
		public Pessoa insert(Pessoa obj) {
			obj.setIdPessoa(null);
			return repo.save(obj);
		}

		public Pessoa update(Pessoa obj) {
			Pessoa newObj = find(obj.getIdPessoa());
			updateData(newObj, obj);
			return repo.save(newObj);
		}
			
		private void updateData(Pessoa newObj, Pessoa obj) {	
			newObj.setNome(obj.getNome());
			newObj.setCpf(obj.getCpf());
			newObj.setDataNascimento(obj.getDataNascimento());
		}

		public void delete(Integer id) {
			find(id);
			try {
				repo.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir uma pessao que está sendo usada pelo sistema");
			}
			
	    }
		
		//Metodo auxiliar para converte DTO
		public Pessoa fromDTO(PessoaDTO objDTO) {
			return new 
					Pessoa( 
						objDTO.getIdPessoa(), 
						objDTO.getNome(),
						objDTO.getCpf(),
						objDTO.getDataNascimento(),
						objDTO.getIdTipoPessoa(),
						objDTO.getIdUser()
					);
		}



}
