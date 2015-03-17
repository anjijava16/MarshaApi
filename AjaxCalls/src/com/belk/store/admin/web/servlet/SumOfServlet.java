package com.belk.store.admin.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SumOfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SumOfServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doExecute(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doExecute(request, response);
	}

	public void doExecute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer x=Integer.parseInt(request.getParameter("n1"));
		Integer y=Integer.parseInt(request.getParameter("n2"));
		System.out.println(x+"   "+y);
		Integer result=x+y;
		response.getWriter().write(result.toString());
	}

}
