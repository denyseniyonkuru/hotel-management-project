<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>Reception</title>
</head>
<body>
<font color="black">
<h1><a href="checkin">Check-in<a>|<a href="checkout">Check-out<a></h1>
<h2>Check-In Form</h2>

<form action="checkinAction" method="POST">
<table>
<tr>
<td>Names:</td><td>
<select name="names">
<option value=""></option>
<c:forEach var="reservation" items="${pendingReservations}">
<option value="${reservation.names}">${reservation.names}</option>
</c:forEach>
</select> <input type="text" name="otherNames" />
</td>
</tr>
<tr>
<td>Tel.:</td><td><input type="text" name="tel"></td>
</tr>
<tr>
<td>Room ID:</td><td>
<select name="roomId">
     <c:forEach var="room" items="${availableRooms}">
     <option value="${room.roomId}">${room.status}(${room.roomId})</option>
     </c:forEach>
</select>
</td>
</tr>
<tr>
<td>Start Date:</td><td><input type="text" name="startDate"></td>
</tr>
<tr>
<td>End Date: </td><td><input type="text" name="endDate"></td>
</tr>
<tr>
<td colspan=2><input type="submit" name="Checkin" value="Check-in"></td>
</tr>
</table>
</form>




<hr />
<h2>Check Status</h2>
<form action="checkStatus" method="post">
Date From:<input type="text" name="dateFrom" />
<input type="submit" name"checkbtn" value="Check">
</form>


<font color="black">

<h2>Room Bookings Information</h2>
<div class="tableList">

<table class="tableclass">
<tr>
<th>ID</th>
<th>Description</th>
<th>Prices</th>
<th>Bookings</th>
<th>More Info</th>
</tr>

<c:forEach var="room" items="${roomBookings}">
<tr>
<td>${room.key.roomId}</td>
<td>${room.key.description}</td>
<td>${room.key.price}</td>
<td>
<table>
<c:forEach var="booking" items="${room.value}">
<tr>
    <td>${booking.names}</td>
    <td>${booking.startDate} - ${booking.endDate}</td>
    <td><a href="checkout?bookingId=${booking.bookingId}">Checkout</a></td>
</tr>
</c:forEach>
</table>
</td>

<td><a href="roomInfo?roomId=${room.key.roomId}">More Info</a></td></td>
</td>
</tr>
</c:forEach>
</table>
</div>



<h2>Room reservations Information</h2>

<div class="tableList">

<table class="tableclass">
<tr>
<th>ID</th>
<th>Description</th>
<th>Prices</th>
<th>Reservations</th>
<th>More Info</th>
</tr>

<c:forEach var="room" items="${roomReservations}">
<tr>
<td>${room.key.roomId}</td>
<td>${room.key.description}</td>
<td>${room.key.price}</td>
<td>
<table>
<c:forEach var="reservation" items="${room.value}">
<tr>
<td>${reservation.names}</td><td>${reservation.startDate} - ${reservation.endDate}</td>
</tr>
</c:forEach>
</table>
</td>

<td><a href="roomInfo?roomId=${room.key.roomId}">More Info</a></td></td>
</td>
</tr>
</c:forEach>
</table>
</div>

</font>
</body>
</html>