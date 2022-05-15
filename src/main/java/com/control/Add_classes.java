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

import com.to.Classes;
import com.util.HibernateUtil;

/**
 * Servlet implementation class Add_classes
 */
@WebServlet("/Add_classes")
public class Add_classes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_classes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("class");
		SessionFactory sf = HibernateUtil.buildSessionfactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Classes classes = new Classes();
		classes.setClass_name(name);
		s.save(classes);
		t.commit();
		s.close();
		response.sendRedirect("ViewClasses.jsp");
	}

}
