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
			     var postData = $(this).serialize();
			     alert("PostData===>>"+postData);
			     var formURL = $(this).attr("action");
			     $.ajax(
			     {
			         url : "Ajaxexample?n1="+v1+"&n2="+v2,
			         type: "GET",
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
});
</script>

<body>
	<form action="subServlet">
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
				<td><input type="submit" id="sub" ></td>
			</tr>
		</table>
	</form>	
<!-- 	<div id="id2">Msg Here</div>
 --></body>
</html>