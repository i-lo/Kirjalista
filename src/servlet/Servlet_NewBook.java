package servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Book;
//import helper.Helper;
import model.Book;


@WebServlet("/Servlet_NewBook")
public class Servlet_NewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public Servlet_NewBook() {
        super();
        System.out.println("Servlet_NewBook.Servlet_NewBook()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_NewBook.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_NewBook.doPost()");
		/*
		Helper helper = new Helper();
		String tiedot = helper.naytaMuuttujaArvoparit(request, response);
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html"); 		
	    out.println(tiedot);	
	    */
		
		Book book = new Book();
		book.setTitle(request.getParameter("title"));
		
		
	
		
		book.setAuthor(request.getParameter(""));	
	<label>Tekijän etunimi</label>
		<input type="text" name="authorfirstname" id="authorfirstname" value="" size="40"><br>	
	<label>Tekijän sukunimi</label>
		<input type="text" name="authorlastname" id="authorlastname" value="" size="40"><br>
		
		
		book.setPublished(Integer.parseInt(request.getParameter("published")));
		book.setBookLanguage(request.getParameter("language"));
		
		//oma metodi tästä? 
		int owned;
		String oma = request.getParameter("owned");
		if (oma.equals("kyllä")) {
			owned=1;	
		} else {
			owned=0;
		}
		
		book.setOwned(owned);

	
		//tarkista löytyykö suosittelijaa, jos ei niin lisää
		
		
	<label>Suosittelija 1, etunimi</label>
		<input type="text" name="rec1firstname" id="rec1firstname" value=""><br>	
	<label>Suosittelija 1, sukunimi</label>
		<input type="text" name="rec1lastname" id="rec1lastname" value=""><br>
	<label>Suosittelija 2, etunimi</label>
		<input type="text" name="rec2firstname" id="rec2firstname" value=""><br>	
	<label>Suosittelija 2, sukunimi</label>
		<input type="text" name="rec2lastname" id="rec2lastname" value=""><br>
		
		
		
		
		
		
		Dao_Book dao = new Dao_Book();
		
		if(dao.addBook(book)==true) {
			response.sendRedirect("newbook.jsp?lisays=1");
		}else {
			response.sendRedirect("newbook.jsp?lisays=0");
		}
		
	}

	
	
	
	

}
