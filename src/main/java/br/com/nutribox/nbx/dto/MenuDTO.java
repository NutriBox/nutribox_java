package br.com.nutribox.nbx.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import br.com.nutribox.nbx.entity.Menu;

public class MenuDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idMenu;
	@Length(max=20,message = "Tamanho máximo da descrição é de 20 caracteres!")
	private String descGroup;
	private String link;
	private String icone;
	private Boolean active;
	
	public MenuDTO( Menu obj ) {
		idMenu = obj.getIdMenu();
		descGroup = obj.getDescGroup();
		link = obj.getLink();
		icone = obj.getIcone();
		active = obj.getActive();
	}
	
	
	public MenuDTO() {
		super();
	}
			
	public MenuDTO(Integer idMenu, String descGroup, String link, String icone, Boolean active) {
		super();
		this.idMenu = idMenu;
		this.descGroup = descGroup;
		this.link = link;
		this.icone = icone;
		this.active = active;
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



	
	
}
