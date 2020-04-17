<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="./resources/css/index.css">
<script type="text/javascript" src="./resources/js/index.js"></script>
<title>DevOps Practice</title>
</head>
<body>	
	<div class="form">
	<h1>Welcome to DevOps World</h1>
		<form action="sayHello.htm" method="post" onsubmit="return validate();">
			<table>				
				<tbody>
				<tr>
					<th colspan="2">Provide below details</th>
				</tr>
					<tr>
						<td><span class="lbl">Enter your name:</span></td>
						<td><input class="inpText" type="text" name="name" id="name" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input class="sbBtn" type="submit" value="Submit" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html> --%>

<% response.sendRedirect("login.htm"); %>