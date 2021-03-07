/**
 * 
 */
package br.com.nutribox.nbx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.nutribox.nbx.entity.Endereco;
import br.com.nutribox.nbx.entity.Telefone;
import br.com.nutribox.nbx.repositories.EnderecoRepository;
import br.com.nutribox.nbx.services.exceptions.ObjectNotFoundException;

/**
 * @author edy
 *
 */
@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repo;
	
	public List<Endereco> obter(){
		return repo.findAll();
	}

	public Endereco obterId(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow( ()-> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + " tipo: " + Telefone.class.getName()));
		
	}
}
