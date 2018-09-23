package dao;

import java.util.ArrayList;

import model.Author;
import model.Book;


public class Dao_Book extends Dao {

	public boolean addBook(Book book) {
		boolean paluuArvo = true;

		/*
		 * 1. tarkista onko tekij‰ kannassa, jos on: ota id ja jos ei oo niin:
		 * lis‰‰ kantaa ja sitten ota tekij‰n id 2. kun tekij‰ on lis‰tty ja
		 * haettu tekij‰n id, lis‰‰ kirjan tiedot kirja tauluun
		 */
		Author author = this.getAuthor(-1, book.getAuthor().getFirstName(), book.getAuthor().getLastName());
		
		if (author == null) {
			this.addAuthor(book.getAuthor().getFirstName(), book.getAuthor().getLastName());
			
			author = this.getAuthor(-1, book.getAuthor().getFirstName(), book.getAuthor().getLastName());
		}
		

		sql = "INSERT INTO OP_Books(Title, Author_id, Published, Book_language, Owned) VALUES(?,?,?,?,?)";
		try {
			con = yhdista();
			stmtPrep = con.prepareStatement(sql);
			stmtPrep.setString(1, book.getTitle());
			stmtPrep.setInt(2, book.getAuthor().getAuthor_id());
			stmtPrep.setInt(3, book.getPublished());
			stmtPrep.setString(4, book.getBookLanguage());
			stmtPrep.setInt(5, book.getOwned());
			stmtPrep.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			paluuArvo = false;
		}
		return paluuArvo;
	}

	private Author getAuthor(int authorId, String authorFirstName, String authorLastName) {
		
		sql = "SELECT * FROM OP_Authors WHERE First_Name = ? and Last_Name=? or Author_id = ? ";  // jos haluat, et hakee vain lukemattomat, laita: WHERE Book_read=0
		try {
			con=yhdista();

		if(con!=null) { 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, authorFirstName);
			stmtPrep.setString(2, authorLastName);
			stmtPrep.setInt(3,  authorId);
    		rs = stmtPrep.executeQuery();  
    		if(rs.isBeforeFirst()) { //jos kysely tuotti dataa, eli author on kaytossa
    			rs.next();
    			return new Author(rs.getInt("Author_id"), rs.getString("First_Name"), rs.getString("Last_Name"));
    			      			       			
			}	
		}
    		con.close();
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;		
	}

	private boolean addAuthor(String authorFirstName, String authorLastName) {
		boolean successful = true;
		sql = "INSERT INTO OP_Authors(First_name, Last_name) VALUES (?,?)";
		try {
			con = yhdista();
			stmtPrep = con.prepareStatement(sql);
			stmtPrep.setString(1, authorFirstName);
			stmtPrep.setString(2, authorLastName);
			stmtPrep.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			successful = false;
		}

		return successful;
	}
	

	public ArrayList<Book> getBooks() throws Exception{
		ArrayList<Book> books = new ArrayList<Book>();
		sql = "SELECT * FROM OP_Books";  // jos haluat, et hakee vain lukemattomat, laita: WHERE Book_read=0
		con=yhdista();
		if(con!=null){ //jos yhteys onnistui
			stmtPrep = con.prepareStatement(sql);
			rs = stmtPrep.executeQuery(); 
			if(rs!=null){ //jos kysely onnistui	
				while(rs.next()){
					Book book = new Book();
					book.setBookId(rs.getInt("Book_id"));
					book.setTitle(rs.getString("Title"));
					book.setAuthor(this.getAuthor(rs.getInt("Author_id"), "", ""));
					book.setPublished(rs.getInt("Published"));
					book.setBookLanguage(rs.getString("Book_language"));
					book.setBookRead(rs.getInt("Book_read"));
					book.setOwned(rs.getInt("Owned"));
					book.setReview(rs.getInt("Review"));
					book.setWrittenReview(rs.getString("Written_review"));
					
					books.add(book);
				}
			}
			con.close();
		}
		return books;
	}
	
	
	

	

	public boolean poistaAsiakas(int id) throws Exception {
		boolean paluuArvo = true;
		sql = "UPDATE VV_Asiakkaat SET Poistettu=1 WHERE Asiakas_id=?";
		try {
			con = yhdista();
			stmtPrep = con.prepareStatement(sql);
			stmtPrep.setInt(1, id);
			stmtPrep.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			paluuArvo = false;
		}
		return paluuArvo;
	}

}
