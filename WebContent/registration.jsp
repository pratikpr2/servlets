
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<img src="google.jpg" alt="Image Logo" width="160em" height="100">
</div>
<div align ="center">
<form action="regServlet" method="post">
<div align="center" style="width:180px">
FirstName : <input type="text" name="firstname" required="required"> <br>
</div>
<div align="center" style="width:180px">
LastName  : <input type="text" name="lastname" required ="required"><br>
</div>
<div align="center" style="width:180px">
E-mail    :	<input type="text" name = "email" required="required"> <br>
</div>
<div align="center" style="width:180px">
password  : <input type="password" name = "password" id ="myInput" required="required"><br>
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
<input type="submit" value="REGISTER">

</form>
</div>
</body>
</html>