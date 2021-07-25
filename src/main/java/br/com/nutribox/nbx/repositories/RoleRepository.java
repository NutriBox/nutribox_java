package br.com.nutribox.nbx.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nutribox.nbx.entity.Role;
import br.com.nutribox.nbx.entity.enums.RoleEnum;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleEnum name);
}
