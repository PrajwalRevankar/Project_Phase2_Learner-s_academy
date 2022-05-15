<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.util.HibernateUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.to.Teacher" %>
<%@ page import="com.to.Subject" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View teacher</title>
</head>
<body>
<%
SessionFactory sf = HibernateUtil.buildSessionfactory();
Session svt = sf.openSession();
List<Teacher> teachers = svt.createQuery("from Teacher").list();
%>
<h2>Teacher's list:</h2>
<br>
<table>
<tr>
<th>Teacher</th>
<th>Assigned subject</th>
</tr>
<%
for(Teacher teach : teachers){
	out.print("<tr>");
	out.print("<td>"+teach.getTeacher_name()+"</td>");
	
	StringBuffer b = new StringBuffer();
	boolean first = true;
	for(Subject sub : teach.getSubjects()){
		if(first == true){
			b.append("<td>"+sub.getSubject_name()+"</td>");
			b.append("</tr>");
			first = false;
		}
		else{
			b.append("<tr><td></td><td></td>");
			b.append("<td>"+sub.getSubject_name()+"</td>");
			b.append("</tr>");
		}
	}
	out.print(b.toString());
}
%>
</table>
<br><br><br>
<a href="AddTeacher.html">Add teacher</a><br>
<a href="Index.html">Main Menu</a><br>
</body>
</html>