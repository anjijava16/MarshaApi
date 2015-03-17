<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.iwinner.mashap.form.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Result Page</h2>
	<%
		List<DeploymentForm> listDepl = (List<DeploymentForm>) session
				.getAttribute("listOfDep");
	%>
	<table class=ridge border=1 width="100%">
		<tr>
			<th class=text>Name</th>
			<th class=text>LOGO</th>
			<th class=text>WebSite</th>
			<%
				for (int i = 0; i < listDepl.size(); i++) {
					DeploymentForm dF = (DeploymentForm) listDepl.get(i);
			%>
		
		<tr>
			<td class=text><%=dF.getName()%></td>
			<td class=text><img src='<%=dF.getLogo()%>' alt="Smiley face" height="42" width="42"/></td>
			<td class=text><a href='<%=dF.getWebsite()%>'><%=dF.getWebsite()%></a> </td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>