package vn.vnpost.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permisson database table.
 * 
 */
@Entity
@Table(name="permisson")
public class PermissonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="code",unique = true)
	private String code;

	@Column(name="name")
	private String name;

	@Column(name="status",columnDefinition = "int default 1")
	private int status;

	@Column(name="url")
	private String url;

	//bi-directional many-to-one association to ActionEntity
	@OneToMany(mappedBy="permisson")
	private List<ActionEntity> actions;

	//bi-directional many-to-many association to GroupEntity
	@ManyToMany(mappedBy="permissons")
	private List<GroupEntity> groups;

	public PermissonEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<ActionEntity> getActions() {
		return this.actions;
	}

	public void setActions(List<ActionEntity> actions) {
		this.actions = actions;
	}

	public ActionEntity addAction(ActionEntity action) {
		getActions().add(action);
		action.setPermisson(this);

		return action;
	}

	public ActionEntity removeAction(ActionEntity action) {
		getActions().remove(action);
		action.setPermisson(null);

		return action;
	}

	public List<GroupEntity> getGroups() {
		return this.groups;
	}

	public void setGroups(List<GroupEntity> groups) {
		this.groups = groups;
	}

}