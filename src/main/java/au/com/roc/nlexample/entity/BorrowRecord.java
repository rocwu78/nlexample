package au.com.roc.nlexample.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

/**
 * Represents a book borrow record
 * 
 * @author Roc 29/04/2016
 */
@Entity
public class BorrowRecord {
	private Integer id;

	private Book book;

	private Borrower borrower;

	private Date borrowDate;
	
	private boolean returned;

	private int version;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookID", nullable = false)
	public Book getBook() {
		return book;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "borrowerID", nullable = false)
	public Borrower getBorrower() {
		return borrower;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
