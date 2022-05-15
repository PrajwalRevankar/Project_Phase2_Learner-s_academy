package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.to.Classes;
import com.to.Subject;
import com.util.HibernateUtil;

/**
 * Servlet implementation class assignSubject
 */
@WebServlet("/assignSubject")
public class assignSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cl_name = request.getParameter("classname");
		String sb_name = request.getParameter("subjectname");
		
		SessionFactory sf = HibernateUtil.buildSessionfactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		
		String hql_classes = "from Classes where class_name='"+cl_name+"'";
		List<Classes> classes = ss.createQuery(hql_classes).list();
		
		String hql_subject = "update Subject s set s.classes=:n where s.subject_name=:sn";
		Query<Subject> subjects = ss.createQuery(hql_subject);
		subjects.setParameter("n", classes.get(0));
		subjects.setParameter("sn", sb_name);
		
		subjects.executeUpdate();
		
		t.commit();
		ss.close();
		
		response.sendRedirect("ViewClasses.jsp");
	}

}
