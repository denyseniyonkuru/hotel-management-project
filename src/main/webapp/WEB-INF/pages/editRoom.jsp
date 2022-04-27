<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>

<title>Edit Room</title>
</head>
<body>
<font color="black">
<h1>Edit Room</h1>
<form action="editRoom" method="post">
<table>
<tr>
<td> Description:</td>
<td><input type="hidden" name="roomId"value="${roomId}"/><input type="text" name="description"value="${description}"></td>
</tr>
<tr>
<td>Price:</td>
<td><input type="number" name="price" value="${price}"></td>
</tr>
<tr>
<td>Status</td>
<td><input type="text" name="status" value="${status}"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="editroombtn" value="Edit Room"></td>
</tr>
</table>
</form>
</font>
</body>
</html>