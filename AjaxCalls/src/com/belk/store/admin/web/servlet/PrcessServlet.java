package com.belk.store.admin.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrcessServlet() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String clientSay = request.getParameter("say");
		String serverResponse = clientSay + " received";
		response.getWriter().write(serverResponse);
		response.flushBuffer();
	}

}
