<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<style>
label{
    display:inline-block;
    width:120px;
    text-align:right;
    vertical-align:top;
}
label.error {
	width:80px;	
    color: red; 
    text-align:left;  
}
#asiakasTiedot{
	border-radius:15px;
	width:500px;
}
</style>
</head>


<body>

<fieldset id="kirjanTiedot">
	<legend>Kirjan tiedot:</legend>
	<form action="Servlet_NewBook" method="post" id="newForm">
		<label>Nimike</label>
			<input type="text" name="title" id="title" value="" size="40"><br>	
		<label>Tekijän etunimi</label>
			<input type="text" name="authorfirstname" id="authorfirstname" value="" size="40"><br>	
		<label>Tekijän sukunimi</label>
			<input type="text" name="authorlastname" id="authorlastname" value="" size="40"><br>	
		<label>Julkaisuvuosi</label>
			<input type="text" id="published" size="5">&nbsp;
		<label>Kieli</label>
			<input type="text" name="language" id="language" value="" size="40"><br>	
		
		<label>Oma kirja? (Kyllä/ei)</label>  
		<%-- lisää validointi eli jos vastattu muuta kuin kyllä/ei niin ei mene läpi!!!!! --%>
			<input type="text" name="owned" id="owned" value=""><br>	
			
			
		<label>Suosittelija 1, etunimi</label>
			<input type="text" name="rec1firstname" id="rec1firstname" value=""><br>	
		<label>Suosittelija 1, sukunimi</label>
			<input type="text" name="rec1lastname" id="rec1lastname" value=""><br>
		<label>Suosittelija 2, etunimi</label>
			<input type="text" name="rec2firstname" id="rec2firstname" value=""><br>	
		<label>Suosittelija 2, sukunimi</label>
			<input type="text" name="rec2lastname" id="rec2lastname" value=""><br>
		<label></label>	
			<input type="submit" value="Lisää uusi" id="addBtn">
		<%
		if(request.getParameter("lisays")!=null){
			if(request.getParameter("lisays").equals("1")){
				out.print("Kirja lisätty");
			}else{
				out.print("Kirjan lisääminen ei onnistunut.");
			}
		}
		%>
	</form>
</fieldset>
<script>
$(document).ready(function(){
	
	
	$("#postinumero").blur(function(){
	    $.ajax({url: "Servlet_Postitoimi_Ajax?postinumero="+$("#postinumero").val(), success: function(result){
	        $("#postitoimipaikka").html(result);
	    }});
	});	
		
	$("#uusiLomake").validate({						
		rules: {
			etunimi:  {
				required: true,
				minlength: 2				
			},	
			sukunimi:  {
				required: true,
				minlength: 2				
			},
			katuosoite:  {
				required: true,
				minlength: 4
			},	
			postinumero:  {
				required: true,
				number: true				
			},			
			sahkoposti:  {
				required: true,
				email: true			
			},
			puhelin:  {				
				minlength: 3				
			},
			salasana:  {
				required: true,
				minlength: 8				
			},
			salasana2:  {
				required: true,
				minlength: 8,
				equalTo: salasana
			}			
		},
		messages: {
			etunimi: {     
				required: "Puuttuu",
				minlength: "Liian lyhyt"			
			},
			sukunimi: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"
			},
			katuosoite: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"
			},
			postinumero: {
				required: "Puuttuu",
				number: "Ei kelpaa"				
			},	
			sahkoposti: {
				required: "Puuttuu",
				email: "Ei kelpaa"			
			},
			puhelin:  {				
				minlength: "Liian lyhyt"				
			},
			salasana: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"				
			},
			salasana2: {
				required: "Puuttuu",
				minlength: "Liian lyhyt",
				equalTo: "Ei kelpaa"
			}	
		},			
		submitHandler: function (form) {	
			if ($("#postitoimipaikka").html()!=""){
				document.forms["uusiLomake"].submit();
			}else{
				$("#postitoimipaikka").html("<label class='error'>Puuttuu</label>");
			}			
		}		
	});   
});
</script>



</body>
</html>