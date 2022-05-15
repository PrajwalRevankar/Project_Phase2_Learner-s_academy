<%@page import="org.hibernate.SessionFactory" %>
<%@page import="com.util.HibernateUtil" %>
<%@page import="org.hibernate.Session" %>
<%@page import="java.util.List" %>
<%@page import="com.to.Classes" %>
<%@page import="com.to.Student" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign students to class</title>
</head>
<body>
<h2>Assign student to class:</h2>
<%
SessionFactory sf = HibernateUtil.buildSessionfactory();
Session sasc = sf.openSession();
List<Classes> classes = sasc.createQuery("from Classes").list();
List<Student> students = sasc.createQuery("from Student").list();
%>
<form action="assignStudent" method="post">
<table>
<thead>
<tr>
<th>Student</th>
<th>Class</th>
</tr>
</thead>
<tbody>
<tr>
<td>
<select name="Sname">
<%
for(Student stu : students){
	out.print("<option>"+stu.getStudent_name()+"</option>");
}
%>
</select>
</td>
<td>
<select name="Cname">
<%
for(Classes clas : classes){
	out.print("<option>"+clas.getClass_name()+"</option>");
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