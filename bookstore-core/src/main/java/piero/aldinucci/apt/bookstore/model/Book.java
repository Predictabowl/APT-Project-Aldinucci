package piero.aldinucci.apt.bookstore.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Domain class
 *
 */

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Author> authors;

	/**
	 * Zero argument contructor needed by JPA entity. 
	 */
	public Book() {
	}

	/**
	 * 
	 * @param id identifier and primary key for the Book model
	 * @param title the title of the book
	 * @param authors collection of Author that wrote the book
	 */
	public Book(Long id, String title, Set<Author> authors) {
		this.id = id;
		this.title = title;
		this.authors = authors;
	}

	/**
	 * 
	 * @return identifier and primary key for the Book model
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id identifier and primary key for the Book model
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return the title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title the title of the book
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return collection of Author that wrote the book
	 */
	public Set<Author> getAuthors() {
		return authors;
	}

	/**
	 * 
	 * @param authors collection of Author that wrote the book
	 */
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else
			if (!id.equals(other.id))
				return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [Id=" + id + ", title=" + title + "]";
	}

}
