package vn.vnpost.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the actiondetail database table.
 * 
 */
@Entity
@Table(name="actiondetail")
public class ActionDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	 @Column(name = "status",columnDefinition = "int default 1")
	private int status;

	 @Column(name = "url")
	private String url;

	//bi-directional many-to-one association to ActionEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="actionid")
	private ActionEntity action;

	//bi-directional many-to-many association to GroupEntity
	@ManyToMany(mappedBy="actiondetails")
	private List<GroupEntity> groups;

	public ActionDetailEntity() {
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

	public ActionEntity getAction() {
		return this.action;
	}

	public void setAction(ActionEntity action) {
		this.action = action;
	}

	public List<GroupEntity> getGroups() {
		return this.groups;
	}

	public void setGroups(List<GroupEntity> groups) {
		this.groups = groups;
	}

}