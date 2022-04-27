<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>Add Room</title>
</head>
<body>
<h1><font color="black">Add Room</font></h1>
<form action="addRoomAction" method="post">
<table>
<tr>
<td><font color="black">Description:</font></td>
<td><input type="text" name="description"></td>
</tr>
<tr>
<td><font color="black">Price:</font></td>
<td><input type="number" name="price"></td>
</tr>
<tr>
<td><font color="black">Status:</font></td>
<td><input type="text" name="status" value="Available" readOnly="true"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="Addroombtn" value="Add Room"></td>
</tr>
</table>
</form>
<hr />
<font color="black">

<h2>Details Of Rooms</h2>

<div class="tableList">

<table class="tableclass">
<tr>
<th>ID</th>
<th>Description</th>
<th>Prices</th>
<th>Status</th>
<th>Edit/Remove</th>
</tr>

<c:forEach var="room" items="${allrooms}">
<tr>
<td>${room.roomId}</td>
<td>${room.description}</td>
<td>${room.price}</td>
<td>${room.status}</td>
<td><a href ="showeditroom?roomId=${room.roomId}&description=${room.description}&price=${room.price}&status=${room.status}">Edit</a>/<a href="removeRoom?id=${room.roomId}">Remove</a></td></td>
</td>
</tr>
</c:forEach>
</table>
</div>
</font>
</body>
</html>