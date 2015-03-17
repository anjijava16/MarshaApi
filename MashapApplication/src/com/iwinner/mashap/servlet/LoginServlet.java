package com.iwinner.mashap.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see HttpServlet#execute(HttpServletRequest request, HttpServletResponse response)
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 String userName=request.getParameter("username");
     String password=request.getParameter("password");
     ServletContext context=this.getServletContext();
     if(userName.equals("anji") &&password.equals("anji")){
     context.setAttribute("usernameAndPassword", "Correct User");
     }
 	request.getRequestDispatcher("/homepage.jsp").forward(request, response);
	}
	}
