<%@page import="org.hibernate.SessionFactory" %>
<%@page import="org.hibernate.Session" %>
<%@page import="com.util.HibernateUtil" %>
<%@page import="com.to.Student" %>
<%@page import="java.util.List" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View student</title>
</head>
<body>
<%
SessionFactory sf = HibernateUtil.buildSessionfactory();
Session svs = sf.openSession();
List<Student> students = svs.createQuery("from Student").list();
%>
<h2>Student's List:</h2>
<table>
<thead>
<tr>
<th><h3>Students</h3></th>
<th><h3>Assigned classes</h3></th>
</tr>
</thead>
<tbody>
<%
for(Student stu : students){
	out.print("<tr>");
	out.print("<td>"+stu.getStudent_name()+"</td>");
	out.print("<td>"+getClassName(stu)+"</td>");
	out.print("</tr>");
}
%>
</tbody>
</table>
<%!
public String getClassName(Student stu){
	if(stu.getClasses() == null){
		return "No class assigned";
	}
	else{
		return stu.getClasses().getClass_name();
	}
}
%>
<br><br><br>
<a href="AddStudent.html">Add Student</a><br>
<a href="assignStudentsToClass.jsp">Assign students to class</a><br>
<a href="Index.html">Main Menu</a><br>

</body>
</html>