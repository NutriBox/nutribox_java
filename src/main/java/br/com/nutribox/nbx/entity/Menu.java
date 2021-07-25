package br.com.nutribox.nbx.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMenu;
	private String descGroup;
	private String link;
	private String icone;	
	private Boolean active;
	@ManyToOne
	@JoinColumn(name = "id")
	private Role role;
	


	public Menu() {}
	
	public Menu(Integer idMenu, String descGroup, String link, String icone, Boolean active, Role role) {		
		this.idMenu = idMenu;
		this.descGroup = descGroup;
		this.link = link;
		this.icone = icone;	
		this.active = active;	
		this.role = role;
	}

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getDescGroup() {
		return descGroup;
	}

	public void setDescGroup(String descGroup) {
		this.descGroup = descGroup;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Menu [idMenu=" + idMenu + ", descGroup=" + descGroup + ", link=" + link + ", icone=" + icone
				+ ", active=" + active + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMenu == null) ? 0 : idMenu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (idMenu == null) {
			if (other.idMenu != null)
				return false;
		} else if (!idMenu.equals(other.idMenu))
			return false;
		return true;
	}





	

}
