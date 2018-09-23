package model;

public class Book {
	private int bookId;
	private String title;
	private Author author;
	private int published;
	private String bookLanguage;
	private int bookRead;
	private int owned;
	private int review;
	private String writtenReview;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(int bookId, String title, String authorFirstName, String authorLastName, int published, String bookLanguage, int bookRead, int owned,
			int review, String writtenReview, Author author) {
		this.bookId = bookId;
		this.title = title;
		this.published = published;
		this.bookLanguage = bookLanguage;
		this.bookRead = bookRead;
		this.owned = owned;
		this.review = review;
		this.writtenReview = writtenReview;
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public String getBookLanguage() {
		return bookLanguage;
	}

	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}

	public int getBookRead() {
		return bookRead;
	}

	public void setBookRead(int bookRead) {
		this.bookRead = bookRead;
	}

	public int getOwned() {
		return owned;
	}

	public void setOwned(int owned) {
		this.owned = owned;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public String getWrittenReview() {
		return writtenReview;
	}

	public void setWrittenReview(String writtenReview) {
		this.writtenReview = writtenReview;
	}

	

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", published=" + published
				+ ", bookLanguage=" + bookLanguage + ", bookRead=" + bookRead + ", owned=" + owned + ", review="
				+ review + ", writtenReview=" + writtenReview + "]";
	}


	
}
