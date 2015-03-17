<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#toCurrency").blur(
						function(e) {
							var v1 =$("#fromCurrency option:selected").text();
							var v2 =$("#toCurrency option:selected").text();
							var postData = $(this).serialize();
							$
									.ajax({
										url : "converion.do?fromCurrency=" + v1
												+ "&toCurrency=" + v2,
										type : "GET",
										data : postData,
										success : function(data, textStatus,jqXHR) {
											$("#res").val(data);
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											alert("Error" + textStatus);
										}
									});
							e.preventDefault(); //STOP default action
							e.unbind(); //unbind. to stop multiple form submit.
						});
			});
</script>

<%
	List listOfCurrency = (List) session.getAttribute("list");
%>
<body>
	<form action="converion.do" >
		<table>
			<tr>
				<td>FromCurrency</td>
				<td><select style="width: 145px;" name="fromCurrency"id="fromCurrency">
						<option value="-1">Please Select</option>
						<%
							for (int i = 0; i < listOfCurrency.size(); i++) {
						%>

						<option value="<%=listOfCurrency.get(i)%>"><%=listOfCurrency.get(i)%></option>

						<%
							}
						%>
					</select>
				</td>
			<tr>
				<td>ToCurrency</td>
				<td><select style="width: 145px;" name="toCurrency"
					id="toCurrency">
						<option value="-1">Please Select</option>
						<%
							for (int i = 0; i < listOfCurrency.size(); i++) {
						%>
						<option value="<%=listOfCurrency.get(i)%>"><%=listOfCurrency.get(i)%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td>Today Rate</td>
				<td><input type="text" name="res" id="res" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="ClickMe" />
	</form>

</body>
</html>