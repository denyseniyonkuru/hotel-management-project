<!DOCTYPE html>
<%@ include file="header.jsp" %>

<script>
         $(function() {
            $( ".dateElement" ).datepicker({
               appendText:"(yy-mm-dd)",
               changeMonth:true,
               changeYear:true,
               yearRange:"c-0:c+1",
               dateFormat:"yy-mm-dd"
            });
         });
</script>


<title>Reservation</title>

<font color="black">
<body>
<h1>Reservation </h1>
<form action="reservation" method="post">
<table>
<td>Names:</td>
<td><input type="hidden" name="roomId" value="${roomId}"/><input type="text" name="names"></td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="email"></td>
</tr>
<tr>
<td>Telephone:</td>
<td><input type="number" name="tel"></td>
</tr>
<tr>
<td>Start Date:</td>
<td><input type="text" name="startDate" class="dateElement"></td>
</tr>
<tr>
<td>End Date:</td>
<td><input type="text" name="endDate" class="dateElement"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="reservationbtn" value="Reservation"></td>
</tr>
</table>
</form>
</font>
<%@ include file="footer.jsp" %>
