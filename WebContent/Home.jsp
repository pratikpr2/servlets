<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div align="center">
<img src="google.jpg" alt="Image Logo" width="160em" height="100">
</div>
<div align="center" >
<form action="preLogin" method="get">
<div align="center" style="width:180px">
Email : <input type="text" name="email" required="required"/><br>
</div>
<div align="center" style="width:180px">
Password: <input type="password" name="password" id ="myInput" required="required"/><br>
</div>
<input type="checkbox" onclick="myFunction()">Show Password

<script>
function myFunction() {
    var x = document.getElementById("myInput");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
</script>
<br>
<input type="submit" value="Login">
</form>
<a href="Registration.jsp">
<input type="submit" value="Register">
</a>
</div>
</body>
</html>