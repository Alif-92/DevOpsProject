<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/css/index.css">
<script type="text/javascript" src="/resources/js/index.js"></script>
<title>DevOps Practice</title>
</head>
<body>
	<h1>Welcome to DevOps World</h1>
	<div class="form">
		<form action="sayHello.htm" method="post" onsubmit="validate();">
			<table>
				<thead>Provide below details</thead>
				<tbody>
					<tr>
						<td>Enter your name:</td>
						<td><input type="text" name="name" id="name" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>