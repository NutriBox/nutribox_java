package br.com.nutribox.nbx.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subMenu")
public class SubMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSubMenu;
	private String descSubMenu;
	private String link;
	private String icone;
	private Boolean active;	
	@OneToOne
	@JoinColumn(name = "idMenu")
	private Menu menu;
	
	public SubMenu() {
		
	}
	
	public SubMenu(Integer idSubMenu, String descSubMenu, String link, String icone, Boolean active , Menu menu) {
		this.idSubMenu = idSubMenu;
		this.descSubMenu = descSubMenu;
		this.link = link;
		this.icone = icone;	
		this.active = active;
		this.menu = menu;
	}
	public Integer getIdSubMenu() {
		return idSubMenu;
	}
	public void setIdSubMenu(Integer idSubMenu) {
		this.idSubMenu = idSubMenu;
	}
	public String getDescSubMenu() {
		return descSubMenu;
	}
	public void setDescSubMenu(String descSubMenu) {
		this.descSubMenu = descSubMenu;
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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "SubMenu [idSubMenu=" + idSubMenu + ", descSubMenu=" + descSubMenu + ", link=" + link + ", icone="
				+ icone + ", active=" + active + ", menu=" + menu + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSubMenu == null) ? 0 : idSubMenu.hashCode());
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
		SubMenu other = (SubMenu) obj;
		if (idSubMenu == null) {
			if (other.idSubMenu != null)
				return false;
		} else if (!idSubMenu.equals(other.idSubMenu))
			return false;
		return true;
	}
	
	

}
