package model;

public class Author {
	private int author_id;
	private String firstName;
	private String lastName;
	
	
	
	public Author(int author_id, String firstName, String lastName) {
		super();
		this.author_id = author_id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public int getAuthor_id() {
		return author_id;
	}
	
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
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
	
	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	

}
