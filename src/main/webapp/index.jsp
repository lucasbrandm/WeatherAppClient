<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Weather Forecast</title>
</head>
<body>
<h1><%= "Weather Forecast" %>
</h1>
<br/>
<form action="weather" method="post">
    <p>City:   <input name="city" type="text"/> </p>
    <p><input type="Submit" value="Search" /> </p>
</form>
</body>
</html>