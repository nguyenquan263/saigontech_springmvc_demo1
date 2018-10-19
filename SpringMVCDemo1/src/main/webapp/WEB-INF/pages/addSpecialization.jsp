<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Add a specialization</title>
<style>
td>input {
	margin: 0;
	height: 100% !important;
	display: inline-block;
	width: 98%;
	border-radius: 0 !important;
}
</style>
</head>
<body>
	<form action="saveSpecialization" method="POST">
		<table border="1" style="width: 50%">
			<tr>
				<th align="left" width="30%">Name:</th>
				<td align="left" width="70%"><input  type="text" name="addName"></td>
			</tr>
			<tr>
				<th align="left" width="30%">Number of credit:</th>
				<td align="left" width="70%"><input type="text" name="addCredit"></td>
			</tr>
		</table>
		<br /> <input style="height: 50px" type="submit" value="Add specialization" />
	</form>
</body>
</html>