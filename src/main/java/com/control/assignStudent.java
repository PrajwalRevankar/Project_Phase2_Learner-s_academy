package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;   

import com.to.Classes;
import com.to.Student;
import com.util.HibernateUtil;

/**
 * Servlet implementation class assignStudent
 */
@WebServlet("/assignStudent")
public class assignStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String student = request.getParameter("Sname");
		String classes = request.getParameter("Cname");
		SessionFactory sf = HibernateUtil.buildSessionfactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		String hql_classes = "from Classes where class_name='"+classes+"'";
		List<Classes> clas = ss.createQuery(hql_classes).list();
		
		String hql_student = "update Student s set s.classes=:n where s.student_name=:sn";
		Query <Student> q = ss.createQuery(hql_student);
		q.setParameter("n", clas.get(0));
		q.setParameter("sn", student);
		
		q.executeUpdate();
		
		t.commit();
		ss.close();
		
		response.sendRedirect("ViewStudent.jsp");
	}

}
