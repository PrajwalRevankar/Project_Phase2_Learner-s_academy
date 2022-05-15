<%@page import="org.hibernate.SessionFactory" %>
<%@page import="org.hibernate.Session" %>
<%@page import="com.util.HibernateUtil" %>
<%@page import="java.util.List" %>
<%@page import="com.to.Subject" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View subject</title>
</head>
<body>
<%
SessionFactory sf = HibernateUtil.buildSessionfactory();
Session svs = sf.openSession();
List<Subject> sub = svs.createQuery("from Subject").list();
%>
<h2>The following subjects are:</h2>
<table>
<thead>
<tr>
<th><h3>Subjects</h3></th>
</tr>
</thead>
<tbody>
<%
for(Subject subject : sub){
	out.print("<tr>");
	out.print("<td>"+subject.getSubject_name()+"</td>");
	out.print("</tr>");
}
%>
</tbody>
</table>
<br><br><br>
<a href="AddSubject.html">Add subject</a><br>
<a href="Index.html">Main Menu</a><br>
</body>
</html>