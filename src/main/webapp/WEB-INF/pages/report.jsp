<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>report</title>
</head>
<body>
<h1><font color="black">Run Report</font></h1>

<form action="reportAction" method="post">
<font color="black">
StartDate:<input type="text" name="startDate">
EndDate:<input type="text" name="endDate">
Data: <select name="dataType">
<option value="booking">Booking</option>
<option value="reservation">Reservation</option>
</select>
<input type="submit" name="run" value="Run Report">
</form>

<hr>
<c:if test="${bookings.size() > 0}">
<div class="tableList">

<form action="printbookingReport" method="post">
<input type="submit" name"printbillbtn" value="Print Report">
</form>

<table class="tableclass">
<tr>
<th>Booking No</th>
<th>Names</th>
<th>Checkin Date</th>
<th>Checkout Date</th>
<th>Nights</th>
<th>Paid amount</th>
</tr>


<c:forEach var="booking" items="${bookings}">
<tr>
<td>${booking.bookingId}</td>
<td>${booking.names}</td>
<td>${booking.startDate}</td>
<td>${booking.checkOutDate}</td>
<td>${booking.nights}</td>
<td>${booking.amount}</td>
</tr>
</c:forEach>
</table>
</div>
</c:if>

</font>
</body>
</html>