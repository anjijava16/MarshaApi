<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
margin :auto;
width: 500px;
background-color: #EEEEEE
}
p.large{
font-size: 20px;
}
p.small{
font-size: 15px;
}
p #displayform{
display: none;
}
</style>
</head>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	 $("#updateUsername").submit(function(e){
		$.ajax({
			url : "update",
			type : "POST",
			dataType : "json",
			data : $("#updateUsername").serialize(),
			success :function(data){
				if(data.isValid){
					$("#displayform").html("Your Name is :"+data.username);
				}else{
					alert("Please Enter Your Name");
				}
			}
		});
		return false;
	});
});
</script>
<body>
<p class="large">JSON Calls</p>
<form id="updateUsername">
 <large for="username"> what is Your Name</large>
 <input type="text" name="username" id="username"/>
 <input type="submit"/>
</form>
<p id="displayform"/>
<hr/>
<p class="small">Resource:http://www.google.com</p>
</body>
</html>