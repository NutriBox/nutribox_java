package br.com.nutribox.nbx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nutribox.nbx.entity.Agenda;

@Repository
public interface  AgendaRepository extends JpaRepository<Agenda, Long> {

}
