package Entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table (name="author")

public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birth_date")
	private String bdate;
	
	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	@Column(name="nationality")
	private String natonality;
	
	@OneToMany (mappedBy="book", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	//se excluye CascadeType.REMOVE
	List <Book> books = new ArrayList<>();
	
	public Author(String firstName, String lastName, String natonality, List<Book> books) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.natonality = natonality;
		this.books = books;
	}

	public Author() {}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNatonality() {
		return natonality;
	}

	public void setNatonality(String natonality) {
		this.natonality = natonality;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

		


		
	}
	