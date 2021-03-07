/**
 * 
 */
package br.com.nutribox.nbx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nutribox.nbx.entity.Endereco;

/**
 * @author edy
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer>{

}
