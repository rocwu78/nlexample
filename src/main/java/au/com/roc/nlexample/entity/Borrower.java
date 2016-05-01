package au.com.roc.nlexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Represents a book borrower
 * 
 * @author Roc 29/04/2016
 */
@Entity
public class Borrower {
	private Integer id;

	private String name;

	private int version;

	private String phone;

	private String email;

	@Column(length = 100)
	public String getEmail() {
		return email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	@Column(length = 100, nullable = false)
	public String getName() {
		return name;
	}

	@Column(length = 20)
	public String getPhone() {
		return phone;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
