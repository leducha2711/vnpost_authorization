package vn.vnpost.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the group database table.
 * 
 */
@Entity
@Table(name="rolegroup")
public class GroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="code")
	private String code;

	@Column(name="name")
	private String name;

	@Column(name="status")
	private int status;

	//bi-directional many-to-many association to ActionDetailEntity
	@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
	@JoinTable(name = "group_actiondetail", joinColumns = @JoinColumn(name="groupid"),
				inverseJoinColumns = @JoinColumn(name="actiondetailid"))
	private List<ActionDetailEntity> actiondetails;

	@OneToMany(mappedBy="group")
	private List<UserEntity> users;

	//bi-directional many-to-many association to PermissonEntity
	@ManyToMany
	@JoinTable(name="permiss_group", joinColumns = @JoinColumn(name="groupid"),
			inverseJoinColumns = @JoinColumn(name="permissid"))
	private List<PermissonEntity> permissons;

	public GroupEntity() {
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

	public List<ActionDetailEntity> getActiondetails() {
		return this.actiondetails;
	}

	public void setActiondetails(List<ActionDetailEntity> actiondetails) {
		this.actiondetails = actiondetails;
	}

	public List<UserEntity> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public List<PermissonEntity> getPermissons() {
		return this.permissons;
	}

	public void setPermissons(List<PermissonEntity> permissons) {
		this.permissons = permissons;
	}

}