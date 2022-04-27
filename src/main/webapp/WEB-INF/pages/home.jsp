<%@ include file="header.jsp" %>

<font color="black">
<h2> Rooms and Prices </h2>

<div class="tableList">

<table class="tableclass">
<tr>
<th>Room ID</th>
<th>Description</th>
<th>Prices</th>
<th>Status</th>
</tr>

<c:forEach var="room" items="${allrooms}">
<tr>
<td>${room.roomId}</td>
<td>${room.description}</td>
<td>${room.price}</td>
<td>
<c:if test="${room.status == 'Available'}">
<a href ="reservation?roomId=${room.roomId}">${room.status}</a>
</c:if>
<c:if test="${room.status != 'Available'}">
${room.status}
</c:if>

</td>
</c:forEach>
</table>
</div>

</font>
<%@ include file="footer.jsp" %>
