<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	 $("#form1").submit(function(e)
			 {
			var v1 = $("#n1").val();
			var v2 = $("#n2").val();
			alert(v1+"  "+v2);
			     var postData = $(this).serializeArray();
			     var formURL = $(this).attr("action");
			     $.ajax(
			     {
			         url : formURL+"?n1="+v1+"&n2="+v2,
			         type: "POST",
			         data : postData,
			         success:function(data, textStatus, jqXHR)
			         {
			            alert("data  "+data);
			            $("#res").val(data);
			         },
			         error: function(jqXHR, textStatus, errorThrown)
			         {
			            alert("Error"+textStatus);
			         }
			     });
			     e.preventDefault(); //STOP default action
			     e.unbind(); //unbind. to stop multiple form submit.
			 });

			/*  $("#form1").submit(); */
});

</script>

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
				<td>Result</td>
				<td><input type="text" name="res" id="res" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" ></td>
			</tr>
		</table>
	</form>
<!-- 	<div id="id2">Msg Here</div>
 --></body>
</html>

==============================================================================

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
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
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
$( document ).ready(function() {
$("#country").change(function(){
	var str = $("#country").val();
	alert(str);
	 $.ajax({url:"countryAction?country="+str,
			 success:function(result){
				 alert("result.."+result);
		    $("#stateid").html(result);
		    return result;
		  },
		   error:function(){
			   alert("Error ");
		   }  
	 });
	     
	
	});
});
</script>

<body>
	<table>
		<tr>
			<td>Select country name</td>
			<td><select name="country" id="country">
					<option value="">--choose--</option>
					<option value="india">india</option>
					<option value="us">us</option>
			</select></td>
		</tr>
		<tr>
			<td>Select State name</td>
			<td>
				<div id="stateid">
					<select name="state">
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

============================================================

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	 $("#n2").blur(function(e)
			 {
			var v1 = $("#n1").val();
			var v2 = $("#n2").val();
			alert(v1+"  "+v2);
			     var postData = $(this).serialize();
			     alert("PostData"+postData);
			     var formURL = $(this).attr("action");
			     $.ajax(
			     {
			         url : "Ajaxexample?n1="+v1+"&n2="+v2,
			         type: "POST",
			         data : postData,
			         success:function(data, textStatus, jqXHR)
			         {
			        	 alert("Checking "+data+" textStatus "+textStatus+" jqXHR"+jqXHR);
			            alert("data  "+data);
			            $("#res").val(data);
			         },
			         error: function(jqXHR, textStatus, errorThrown)
			         {
			            alert("Error"+textStatus);
			         }
			     });
			     e.preventDefault(); //STOP default action
			     e.unbind(); //unbind. to stop multiple form submit.
			 });

			/*  $("#form1").submit(); */
});

</script>

<body>
	
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
				<td>Result</td>
				<td><input type="text" name="res" id="res" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" ></td>
			</tr>
		</table>
<!-- 	<div id="id2">Msg Here</div>
 --></body>
</html>
==================================PLan Ajax Calls=============
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

