<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>Add User</title>
</head>
<body>
<h1><font color="black">Add User</font></h1>
<form action="addUser" method="post">
<table>
<tr>
<td><font color="black">Name:</font></td>
<td><input type="text" name="names"></td>
</tr>
<tr>
<td><font color="black">UserName:</font></td>
<td><input type="text" name="userName"></td>
</tr>
<tr>
<td><font color="black">Password:</font></td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><font color="black">Role:</font></td>
<td><input type="text" name="role"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="Adduserbtn" value="Add User"></td>
</tr>
</table>
</form>
</body>
</html>