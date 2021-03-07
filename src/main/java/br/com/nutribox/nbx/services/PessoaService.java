package br.com.nutribox.nbx.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nutribox.nbx.entity.Pessoa;
import br.com.nutribox.nbx.repositories.PessoaRepository;
import br.com.nutribox.nbx.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	
	public Pessoa obterId(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + " tipo: " + Pessoa.class.getName()));
	}
}
