package com.controller;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;


import com.dao.DBApplication;
import com.model.Register;

public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public DisplayServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("dsplayserv1");
		DBApplication db=new DBApplication();//new object
		List<Register> lst=db.getAllData();//
		System.out.println("dsplayserv2");
		System.out.print("<table>");
		for(Register r:lst)
		{
	System.out.println("<tr><td>"+r.getUno()+"</td><td>"+r.getFname()+"</td><tr>"+r.getPass()+"</td><tr>"+r.getBal());//print data in table
		}
		System.out.println("</table>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
		/*HttpSession session=request.getSession(true);
		session.setAttribute("data",lst);
		response.sendRedirect("DisplayAll.jsp");
	*/

