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

import com.to.Subject;
import com.to.Teacher;
import com.util.HibernateUtil;

/**
 * Servlet implementation class assignTeacher
 */
@WebServlet("/assignTeacher")
public class assignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignTeacher() {
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
		String tname = request.getParameter("teacherName");
		String sname = request.getParameter("subjectName");
		
		SessionFactory sf = HibernateUtil.buildSessionfactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		
		String teacher_hql = "from Teacher where teacher_name='"+tname+"'";
		List<Teacher> teacher = ss.createQuery(teacher_hql).list();
		
		String subject_hql = "update Subject s set s.teacher=:n where s.subject_name=:sn";
		Query<Subject> q = ss.createQuery(subject_hql);
		q.setParameter("n", teacher.get(0));
		q.setParameter("sn", sname);
		
		q.executeUpdate();
		t.commit();
		ss.close();
		response.sendRedirect("ViewTeacher.jsp");
		
	}

}
