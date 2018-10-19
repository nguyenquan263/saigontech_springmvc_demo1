<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Specialization List</title>

</head>
<%
	String noti = request.getParameter("notification");
	
	if (noti == null) noti = "";
%>
<body>
	<h2>List of Specialization</h2>
	
	<h4 style="color: red"><%=noti%></h4>
	<form action="deleteSpecialization" method="GET">
		<table border="1" style="width: 500px">
			<tr>
				<th width="10%">ID</th>
				<th width="50%">Name</th>
				<th width="30%">Credit</th>
				<th width="10%"><input type="submit" value="Delete" /></th>

			</tr>
			<c:forEach items="${listSpecialization}" var="spec" varStatus="loop">

				<tr>
					<td>${loop.index + 1}</td>
					<td><a href="updateSpecialization?idUpdate=${spec.ID}">${spec.name}</a></td>
					<td>${spec.numberCredit}</td>
					<td><input type="checkbox" name="idDelete" value="${spec.ID}" /></td>
				</tr>

			</c:forEach>
		</table>
	</form>
</body>
<br />
<a href="addSpecialization"><button style="height: 50px">ADD
		SPECIALIZATION</button></a>
</html>