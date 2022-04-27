<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>Reception</title>
</head>
<body>
<font color="black">
<h1><a href="checkin">Check-in<a>|<a href="checkout">Check-out<a></h1>
<h2>Check Status</h2>
<form action="checkStatus" method="post">
Status:<select name="status">
<option value="All">All</option>
<option value="Available">Available</option>
<option value="Reserved">Reserved</option>
<option value="Booked">Booked</option>
</select>
<input type="submit" name"checkbtn" value="Check">
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

<c:forEach var="room" items="${rooms}">
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