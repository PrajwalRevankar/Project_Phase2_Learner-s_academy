<%@page import="org.hibernate.SessionFactory" %>
<%@page import="com.util.HibernateUtil" %>
<%@page import="org.hibernate.Session" %>
<%@page import="java.util.List" %>
<%@page import="com.to.Classes" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class report</title>
</head>
<body>
<div align="center">
<h2>Class Report</h2>
</div>
<%
SessionFactory sf = HibernateUtil.buildSessionfactory();
Session s = sf.openSession();
List<Classes> classes = s.createQuery("from Classes").list();
%>
<form action="Report" method="post">
<h3>Mention class name to generate the report:</h3>
<table>
<tr>
<th>
Class:
</th>
</tr>
<tr>
<td>
<select name="class">
<%
for(Classes cl : classes){
	out.print("<option>"+cl.getClass_name()+"</option>");
}
%>
</select>
</td>
</tr>
<tr>
<th><input type="submit" value="submit"></th>
</tr>
</table>
</form>
<br><br><br>
<a href="Index.html">Main Menu</a><br>
</body>
</html> 