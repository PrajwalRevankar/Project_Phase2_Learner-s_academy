<%@page import="org.hibernate.SessionFactory" %>
<%@page import="com.util.HibernateUtil" %>
<%@page import="org.hibernate.Session" %>
<%@page import="java.util.List" %>
<%@page import="com.to.Classes" %>
<%@page import="com.to.Subject" %>
<%@page import="com.to.Teacher" %>
<%@page import="com.to.Student" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class report</title>+
</head>
<body>
<div align="center">
<h2>Class Report</h2>
</div>
<%
String cname =(String)request.getAttribute("name");
%>
<h2>Class report for <%=cname %>:</h2>
<%
SessionFactory sf = HibernateUtil.buildSessionfactory();
Session s = sf.openSession();
List<Classes> cl = s.createQuery("from Classes").list(); 
int i = ((Integer)request.getAttribute("index")).intValue();
Classes classReport = cl.get(i);
%>

<table>
<tr>
<th>Subject</th>
<th>Teacher</th>
</tr>
<%
for(Subject sub : classReport.getSubjects()){
	out.print("<tr>");
	out.print("<td>"+sub.getSubject_name()+"</td>");
	out.print("<td>"+getTeacherName(sub)+"</td>");
	out.print("</tr>");
}
%>
</table>
<%! public String getTeacherName(Subject subject){
		Teacher teacher = subject.getTeacher();
		String name;
		
		if(teacher != null){
			name = teacher.getTeacher_name();
			return name;
		}
		else{
			return "No teacher assigned";
		}
}


%>
<br>
<table>
<tr>
<th>Assigned Students</th>
</tr>
<%
for(Student stu : classReport.getStudents()){
	out.print("<tr>");
	out.print("<td>"+stu.getStudent_name()+"</td>");
	out.print("</tr>");
}
%>
</table>

<br><br><br>
<a href="classReport.jsp">Back</a><br>
<a href="Index.html">Main Menu</a><br>
</body>
</html>