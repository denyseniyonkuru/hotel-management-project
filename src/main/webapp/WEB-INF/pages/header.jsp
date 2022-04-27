<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    	<link href="css/jquery-ui.css" rel="stylesheet" />
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
    background-color: #ddd;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}

.tableclass {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

.tableclass td, .tableclass th {
  border: 1px solid #ddd;
  padding: 8px;
}

.tableclass tr:nth-child(even){background-color: #f2f2f2;}

.tableclass tr:hover {background-color: #ddd;}

.tableclass th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
 }
 .tableList{
   width: 100%;
   height: 500px;
   border: 1px dotted black;
   overflow: scroll;
 }
</style>


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


</head>
<body>

<div class="topnav">
  <a class="active" href="home">Home</a>
  <div align="right">
  <form action="login" method="post">
  <font color="white">UserName:</font><input type="text" name="username" size="4" />
  <font color="white">Password:</font><input type="password" name="password" size="4" />
  <input type="submit" name="submitbtn" value="Login" />
  </form>
  </div>
</div>
<div align="right">
<c:if test="${Izina != null}">
You are logged as: ${Izina}
</c:if>
</div>
<h2>HOTEL MANAGEMENT SYSTEM</h2>
