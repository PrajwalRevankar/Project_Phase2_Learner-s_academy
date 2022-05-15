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

import com.to.Subject;
import com.util.HibernateUtil;

/**
 * Servlet implementation class Add_subject
 */
@WebServlet("/Add_subject")
public class Add_subject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_subject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("subject");
		SessionFactory sf = HibernateUtil.buildSessionfactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Subject sub = new Subject();
		sub.setSubject_name(sname);
		s.save(sub);
		t.commit();
		s.close();
		response.sendRedirect("ViewSubject.jsp");
		
	}

}
