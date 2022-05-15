package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.to.Classes;
import com.util.HibernateUtil;

/**
 * Servlet implementation class Report
 */
@WebServlet("/Report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report() {
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
		// TODO Auto-generated method stub
		String name = request.getParameter("class");
		SessionFactory sf = HibernateUtil.buildSessionfactory();
		Session s = sf.openSession();
		List<Classes> cl = s.createQuery("from Classes").list();
		int count = 0;
		int index = 0;
		for(Classes c : cl) {
			if(c.getClass_name().equals(name)) {
				index = count;
			}
			count++;
		}
		request.setAttribute("name",name);
		request.setAttribute("index", index);
		RequestDispatcher rd =  request.getRequestDispatcher("ViewCLassReport.jsp");
		rd.forward(request, response);
	}

}
