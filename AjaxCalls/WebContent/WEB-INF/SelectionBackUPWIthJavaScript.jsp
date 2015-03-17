<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
           <link rel="stylesheet" type="text/css" href="styles.css">
              -->
</head>
<script>
	function onCountryChange(str) {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			alert(str);
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var x = xmlhttp.responseText;
				alert(x);
				var y = new Array();
				var len = 0;
				var text;
				x=  x.substring(1,x.length-1);
				alert("After.."+x);
			 	y = x.split(',');
			 	
			 	
			 	for (i = 0, len = y.length, text = "<select name='state' onchange='onStateChange(this.value)'>"; i < len; i++) { 
			 	    text = text + "<option value="+y[i] + ">"+y[i] + "</option>";
			 	}
/* 				alert(y.length);
 */					
				document.getElementById("stateid").innerHTML = text;
			}
		};
		xmlhttp.open("GET", "countryAction?country=" + str, true);
		xmlhttp.send();
	}

	function onStateChange(str)

	{
		var xmlhttp;
		if (window.XMLHttpRequest)

		{// code for IE7+, Firefox, Chrome, Opera, Safari
			alert(str);
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				 
				document.getElementById("stateid").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("GET", "stateAction?state=" + str, true);
		xmlhttp.send();
	}
</script>

<body>
	<table>
		<tr>
			<td>Select country name</td>
			<td><select name="country"
				onchange="onCountryChange(this.value)">
					<option value="">--choose--</option>
					<option value="india">india</option>
					<option value="us">us</option>
			</select></td>
		</tr>
		<tr>
			<td>Select State name</td>
			<td>
				<div id="stateid">
					<select name="state" onchange="onStateChange(this.value)">
						<option value=" ">--choose</option>

					</select>
				</div>
			</td>
		</tr>

		<tr>
			<td>Select city name</td>
			<td>
				<div id="cityId">
					<select name="city">
						<option value=" ">--choose</option>
					</select>
				</div>
			</td>
		</tr>


	</table>
</body>
</html>
