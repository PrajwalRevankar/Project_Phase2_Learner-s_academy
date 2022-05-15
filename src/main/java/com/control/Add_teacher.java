package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.to.Teacher;
import com.util.HibernateUtil;

/**
 * Servlet implementation class Add_teacher
 */
@WebServlet("/Add_teacher")
public class Add_teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("teacher");
		SessionFactory sf = HibernateUtil.buildSessionfactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Teacher tchr = new Teacher();
		tchr.setTeacher_name(name);
		s.save(tchr);
		t.commit();
		s.close();
		response.sendRedirect("ViewTeacher.jsp");
	}

}
