<html>

<head>
    <title>
        jQuery UI | Date Picker
    </title>

 <!--   <link href='jquery-ui-1.12.1/jquery-ui.css' rel='stylesheet'>

    <script src="jquery-ui-1.12.1/jquery-ui.min.js" ></script>

    <script src="jquery-ui-1.12.1/jquery-ui.js" ></script>
 -->


  <link rel="stylesheet" href="hotelManagementsystem/resources/js/jquery-ui-1.12.1/jquery-ui.css" type="text/css"/>
  <link rel="stylesheet" href="hotelManagementsystem/resources/css/style.css" type="text/css" />
  <script src="hotelManagementsystem/resources/js/jquery-ui-1.12.1/jquery-1.12.4.js"  type="text/javascript"></script>
  <script src="hotelManagementsystem/resources/js/jquery-ui-1.12.1/jquery-ui.js"  type="text/javascript"></script>




</head>

<body>
    Date: <input type="text" id="my_date_picker">

    <script>
        $(document).ready(function() {

            $(function() {
                $( "#my_date_picker" ).datepicker();
            });
        })
    </script>
</body>

</html>
