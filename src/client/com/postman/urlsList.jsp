<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="list"  method = "post">
        <select name="url">
    		<c:forEach items="${File}" var="file">
        		<option value="${file.getParamNames()}">${file.urlPath}</option>
    		</c:forEach>
		</select>
        <br/><br/>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>