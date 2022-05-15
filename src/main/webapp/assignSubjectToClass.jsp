<%@page import="org.hibernate.SessionFactory" %>
<%@page import="com.util.HibernateUtil" %>
<%@page import="org.hibernate.Session" %>
<%@page import="java.util.List" %>
<%@page import="com.to.Classes" %>
<%@page import="com.to.Subject" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign subject</title>
</head>
<body>
<h1>Assign subject to a class</h1>
<%
SessionFactory sf = HibernateUtil.buildSessionfactory();
Session sasc = sf.openSession();
List<Classes> classes = sasc.createQuery("from Classes").list();
List<Subject> subjects = sasc.createQuery("from Subject").list();
%>

<form action="assignSubject" method="post">
<table>
<thead>
<tr>
<th>Class</th>
<th>Subject</th>
</tr>
</thead>
<tbody>
<tr>
<td>
<select name="classname">
<%
for(Classes clas : classes){
	out.print("<option>"+clas.getClass_name()+"</option>");
}
%>
</select>
</td>
<td>
<select name="subjectname">
<%
for(Subject sub : subjects){
	out.print("<option>"+sub.getSubject_name()+"</option>");
}
%>
</select>
</td>
</tr>
<tr>
<td><input type="submit" value="submit"></td>
</tr>
</tbody>
</table>
</form>
</body>
</html>