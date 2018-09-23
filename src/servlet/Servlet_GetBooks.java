package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Book;
import model.Book;


	@WebServlet("/Servlet_GetBooks")
	public class Servlet_GetBooks extends HttpServlet {
		private static final long serialVersionUID = 1L;
	          
	    public Servlet_GetBooks() {
	        super();     
	        System.out.println("Servlet_GetBooks.Servlet_GetBooks()");
	    }
	    
	    
	    
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Servlet_GetBooks.doGet()");
			Dao_Book dao = new Dao_Book();
			try {
				ArrayList<Book> books = dao.getBooks();
				request.setAttribute("books", books);		
				String jsp = "/booklist.jsp"; 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Servlet_GetBooks.doPost()");
		}

}