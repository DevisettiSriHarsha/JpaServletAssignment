<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addBookServlet" method="post">

		Select Library : <select name="library" id="library">
			<option value="National">National</option>
			<option value="Academic">Academic</option>
			<option value="Sports">Sports</option>
			<option value="International">International</option>
		</select> 
		Book Id : <input type="text" name="bid"> <br>
		<br> Book Name : <input type="text" name="bname"> <br>
		<br> Author : <input type="text" name="auth"> <br>
		<br> Publisher : <input type="text" name="publ"> <br>
		<br> <input type="submit" value="ADD">
</form>

</body>
</html>