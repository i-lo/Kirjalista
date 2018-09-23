<%@ page import="java.util.*"%>  
<%@ page import="model.Book"%> 
<%! @SuppressWarnings("unchecked") %>
<% 
ArrayList<Book> booklist=null;
if(request.getAttribute("books")!=null){
	booklist = (ArrayList<Book>)request.getAttribute("books");	
}else{
	response.sendRedirect("Servlet_GetBooks");	
	return;
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
for(int i=0; i<booklist.size();i++){
	out.print("<tr>");
	out.print("<td>" + booklist.get(i).getTitle() + "</td>");
	out.print("<td>" + booklist.get(i).getAuthor().toString() + "</td>");
	//out.print("<td><a href='Servlet_PoistaAsiakas?poista_id="+asiakkaat.get(i).getAsiakas_id()+"'>X</a></td>");	
	//tai
	//out.print("<td><span onclick='poista("+asiakkaat.get(i).getAsiakas_id()+")'>X</span></td>");	
	//out.print("</tr>");
}
%>
</table>
<script>
//function poista(id){
	//var r = confirm("Haluatko varmasti poistaa asiakkaan " + id + "?");
	//if (r == true) {
	//    document.location="Servlet_PoistaAsiakas?poista_id="+id;
	} 
}
</script>















</body>
</html>