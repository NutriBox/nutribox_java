package br.com.nutribox.nbx.dto;

import java.io.Serializable;

import br.com.nutribox.nbx.entity.Menu;
import br.com.nutribox.nbx.entity.SubMenu;

public class SubMenuDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idSubMenu;
	private String descSubMenu;
	private String link;
	private String icone;
	private Boolean active;
	private Menu menu;
	
	public SubMenuDTO( SubMenu obj ) {
		idSubMenu = obj.getIdSubMenu();
		descSubMenu = obj.getDescSubMenu();
		link = obj.getLink();
		icone = obj.getIcone();
		active = obj.getActive();
		menu = obj.getMenu();		
	}

	public SubMenuDTO() {}

	public SubMenuDTO(Integer idSubMenu, String descSubMenu, String link, String icone, Boolean active, Menu menu) {
		super();
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


}
