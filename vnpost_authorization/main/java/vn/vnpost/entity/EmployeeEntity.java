package vn.vnpost.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@Getter
@Setter
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
//	@GeneratedValue(generator = "employeegenerator")
//	@GenericGenerator(name="employeegenerator",strategy = "vn.vnpost.generator.EmployeeGenerator")
	private String id;

	@Column(name = "address")
	private String address;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateofbirth")
    private Date dateOfBirth;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "gender",columnDefinition = "int default 1")
	private int gender;

	@Column(name = "idcard")
	private String idcard;

	@Column(name = "phonenumber")
	private String phonenumber;

	@Column(name = "status",columnDefinition = "int default 1")
	private int status;

	@Column(name = "typeidcard")
	private String typeidcard;
	@Column(name = "email")
	private String email;

	//bi-directional one-to-one association to UserEntity
	@OneToOne(mappedBy="employee", fetch=FetchType.LAZY)
	private UserEntity user;


}