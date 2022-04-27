<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>

<title>Edit User</title>
</head>
<body>
<font color="black">
<h1>Edit User</h1>
<form action="editUser" method="post">
<table>
<tr>
<td> Name:</td>
<td><input type="hidden" name="id"value="${id}"/><input type="text" name="names"value="${names}"></td>
</tr>
<tr>
<td>User Name:</td>
<td><input type="text" name="userName" value="${userName}"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password " value="${password}"></td>
</tr>
<td>Password</td>
<td><input type="text" name="role" value="${role}"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="edituserbtn" value="Edit User"></td>
</tr>
</table>
</form>
</font>
</body>
</html>