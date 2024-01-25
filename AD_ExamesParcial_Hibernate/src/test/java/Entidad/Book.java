package Entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Formula;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //La opci�n m�s usada con MySQL
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="publication_date")
	private String pubdate;
	
	@Column(name="genre")
	private String genre;
	
	@ManyToOne
	@JoinColumn (name = "author_id")
	private Author author;
	
	
	public Book() {
		
	}
	 
	public Book(String title, String pubdate, String genre, Author author) {
		super();
		this.title = title;
		this.pubdate = pubdate;
		this.genre = genre;
		this.author = author;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPubdate() {
		return pubdate;
	}


	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	
}
