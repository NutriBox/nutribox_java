package br.com.nutribox.nbx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nutribox.nbx.entity.SubMenu;

@Repository
public interface SubMenuRepositories extends JpaRepository<SubMenu, Integer> {

}
