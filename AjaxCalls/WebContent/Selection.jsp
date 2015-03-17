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
