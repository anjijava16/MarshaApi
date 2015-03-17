package com.belk.store.admin.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class UpdateJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateJson() {
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
		String username=request.getParameter("username");
		System.out.println("UserName"+username);
		Map<String,Object>map=new HashMap<String,Object>();
		boolean isValid=false;
		if(username!=null&&username.trim().length()!=0){
			isValid=true;
			map.put("username", username);
		}
		map.put("isValid", isValid);
		System.out.println(map);
		write(response,map);
	}
	private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));
	}

}
