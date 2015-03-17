package com.belk.store.admin.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxCallingServlet
 */
public class AjaxCallingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxCallingServlet() {
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
    	
	}


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	execute(request,response);
	}
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String name=null;
    	  name = "Hello "+request.getParameter("userName");
    	  if(request.getParameter("user").toString().equals("")){
    	   name="Hello User";
    	  }
    	  response.setContentType("text/plain");  
    	  response.setCharacterEncoding("UTF-8"); 
    	  response.getWriter().write(name); 
    	 }

}
