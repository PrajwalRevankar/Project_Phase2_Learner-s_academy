<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.util.HibernateUtil" %>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@page import="com.to.Classes"%>
<%@page import="com.to.Subject"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View classes</title>
</head>
<body>
<%
SessionFactory sf = HibernateUtil.buildSessionfactory();
Session svc = sf.openSession();
List<Classes> classes = svc.createQuery("from Classes").list();

%>
<h2>The following classes are:</h2>
<table>
<thead>
<tr>
<th><h3>Class</h3></th>
<th><h3>Subject</h3></th>
</tr>
</thead>
<tbody>
<tr>
<%
for(Classes c : classes){
	out.print("<tr>");
	out.print("<td>"+c.getClass_name()+"</td>");
	
	StringBuffer sbuf = new StringBuffer();
	boolean first = true;
	for(Subject subject : c.getSubjects()){
		if(first == true){
			sbuf.append("<td>"+subject.getSubject_name()+"</td>");
			sbuf.append("</tr>");
			first = false;
		}
		else{
			sbuf.append("<tr><td></td>");
			sbuf.append("<td>"+subject.getSubject_name()+"</td>");
			sbuf.append("</tr>");
		}
	}
	out.print(sbuf.toString());
	
}
%>
</tbody>
</table>
<br><br><br>
<a href="AddClasses.html">Add Class</a><br>
<a href="assignSubjectToClass.jsp">Assign subject to class</a><br>
<a href="Index.html">Main Menu</a><br>
</body>
</html>