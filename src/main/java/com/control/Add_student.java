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

import com.to.Student;
import com.util.HibernateUtil;

/**
 * Servlet implementation class Add_student
 */
@WebServlet("/Add_student")
public class Add_student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("student");
		SessionFactory sf = HibernateUtil.buildSessionfactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Student stu = new Student();
		stu.setStudent_name(name);
		s.save(stu);
		t.commit();
		s.close();
		response.sendRedirect("ViewStudent.jsp");
	}

}
