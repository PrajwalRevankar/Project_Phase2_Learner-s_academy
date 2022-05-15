<%@page import="org.hibernate.SessionFactory" %>
<%@page import="org.hibernate.Session" %>
<%@page import="com.util.HibernateUtil" %>
<%@page import="com.to.Subject" %>
<%@page import="com.to.Teacher" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Teacher</title>
</head>
<body>
<h2>Assign teacher to subject</h2>
<%
SessionFactory sf = HibernateUtil.buildSessionfactory();
Session sats = sf.openSession();
List<Teacher> teacher = sats.createQuery("From Teacher").list();
List<Subject> subjects = sats.createQuery("from Subject").list();
%>
<form action="assignTeacher" method="post">
<table>
<thead>
<tr>
<th>Teacher</th>
<th>Subject</th>
</tr>
</thead>
<tbody>
<tr>
<td>
<select name="teacherName">
<%
for(Teacher tr : teacher){
	out.print("<option>"+tr.getTeacher_name()+"</option>");
}
%>
</select>
<select name="subjectName">
<%
for(Subject sb : subjects){
	out.print("<option>"+sb.getSubject_name()+"</option>");
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