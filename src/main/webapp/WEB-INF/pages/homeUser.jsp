<%@ include file="headerUser.jsp" %>


<font color="black">
<h2> USERS LIST</h2>

<div class="tableList">
<table class="tableclass">
<tr>
<th>User Id</th>
<th>UserName</th>
<th>Names</th>
<th>Role</th>
<th>Edit/remove</th>
</tr>

<c:forEach var="user" items="${allusers}">
<tr>
<td>${user.id}</td>
<td>${user.userName}</td>
<td>${user.names}</td>
<td>${user.role}</td>
<td><a href ="showedituser?id=${user.id}&userName=${user.userName}&names=${user.names}&password=${user.password}&role=${user.role}">Edit</a>/<a href="removeUser?id=${user.id}">Remove</a></td>
</tr>
</c:forEach>
</table>
</div>
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