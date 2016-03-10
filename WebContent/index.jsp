<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="moviedatabase.html">Movie Database</a>
<form method="post" action="listByGenre.html">
<select name="genre">
  <option value="scifi">SciFi</option>
  <option value="drama">Drama</option>
  <option value="horror">Horror</option>
  <option value="mystery">Mystery</option>
  <option value="musical">Musical</option>
</select>
<input type=submit value="Submit">
</form>
</body>
</html>