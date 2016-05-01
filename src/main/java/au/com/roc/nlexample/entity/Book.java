package au.com.roc.nlexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Represents a book
 * 
 * @author Roc 29/04/2016
 */
@Entity
public class Book {
	private Integer id;

	private int version;

	private String title;

	private String author;

	private String ISBN;

	@Column(length = 100, nullable = false)
	public String getAuthor() {
		return author;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	@Column(length = 20, nullable = false)
	public String getISBN() {
		return ISBN;
	}

	@Column(length = 200, nullable = false)
	public String getTitle() {
		return title;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
