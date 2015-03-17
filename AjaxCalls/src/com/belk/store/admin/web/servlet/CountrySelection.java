package com.belk.store.admin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountrySelection
 */
public class CountrySelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountrySelection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	execute(request,response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	execute(request,response);
	}
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name=request.getParameter("country");
    	 List<String>statemap=new ArrayList<String>();
    	if(name.equals("india")){
    		statemap.add("TG");
    		statemap.add("AP");
    		statemap.add("KA");
    		statemap.add("MH");
    		statemap.add("TN");
    		statemap.add("KL");
    	}
    	if(name.equals("us")){
    		statemap.add("NewYork");
    		statemap.add("WashingDC");
    		statemap.add("MissisUp");
    		statemap.add("Florida");
    	}
    	request.setAttribute("statemap", statemap);
    	String responceString = "";
    		for(int i = 0;i<statemap.size();i++)
    	{
    		responceString = responceString + "<option value='"+statemap.get(i)+"'>"+statemap.get(i)+"</option>";
    	}
    	
    	System.out.println(responceString);
    	
    	responceString = 	"<div id='stateid'><select name='state'>" + responceString + "</select></div>";
    	System.out.println("====================================");
    	System.out.println(responceString);
    	/*responceString = statemap.toString();*/
    	response.getWriter().write(responceString);
	}

}
