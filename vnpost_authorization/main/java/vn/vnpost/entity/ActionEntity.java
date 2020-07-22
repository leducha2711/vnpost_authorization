package vn.vnpost.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the action database table.
 * 
 */
@Entity
@Table(name="action")
public class ActionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	 @Column(name = "code")
	private String code;

	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;

	@Column(name = "status",columnDefinition = "int default 1")
	private int status;
	 @Column(name = "url")
	private String url;

	//bi-directional many-to-one association to ActionDetailEntity
	@OneToMany(mappedBy="action")
	private List<ActionDetailEntity> actiondetails;

	//bi-directional many-to-one association to PermissonEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="permissid")
	private PermissonEntity permisson;

	public ActionEntity() {
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

	public List<ActionDetailEntity> getActiondetails() {
		return this.actiondetails;
	}

	public void setActiondetails(List<ActionDetailEntity> actiondetails) {
		this.actiondetails = actiondetails;
	}

	public ActionDetailEntity addActiondetail(ActionDetailEntity actiondetail) {
		getActiondetails().add(actiondetail);
		actiondetail.setAction(this);

		return actiondetail;
	}

	public ActionDetailEntity removeActiondetail(ActionDetailEntity actiondetail) {
		getActiondetails().remove(actiondetail);
		actiondetail.setAction(null);

		return actiondetail;
	}

	public PermissonEntity getPermisson() {
		return this.permisson;
	}

	public void setPermisson(PermissonEntity permisson) {
		this.permisson = permisson;
	}

}