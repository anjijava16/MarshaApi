<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function formSubmit(){
	var v1=document.getElementById("n1").value;
	var v2=document.getElementById("n2").value;
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	alert(xmlhttp.status);
	xmlhttp.onreadystatechange = function() {
		
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			
			alert("aaaa"+xmlhttp.responseText);
			document.getElementById("ExamIdError").innerHTML = xmlhttp.responseText;
		}
	}
	
	var qString="Ajaxexample?n1="+v1+"&n2="+v2;
	xmlhttp.open("GET",qString ,true);
	xmlhttp.send();
	
	}
</script>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<body>
	<form name="form1" action="Ajaxexample"  id="form1">
		<table>
			<tr>
				<td>Number 1</td>
				<td><input type="text" name="n1"  id="n1"/></td>
			</tr>
			<tr>
				<td>Number 2</td>
				<td><input type="text" name="n2" id="n2" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"  onclick="formSubmit()"></td>
			</tr>
		</table>
	</form>
	<script>
	alert("Before"+$("#n1").val());
	</script>
	<div id="ExamIdError">xxxx</div>
	
	<script>
	alert("After"+$("#n1").val());
	</script>
	
</body>
</html>