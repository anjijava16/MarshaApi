package com.iwinner.mashap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iwinner.mashap.consumer.api.GetDeploymentToolOperation;
import com.iwinner.mashap.dao.DeploymentDaoImpl;
import com.iwinner.mashap.form.DeploymentForm;

/**
 * Servlet implementation class GetImageServlet
 */
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	execute(request,response);
	}
	/**
	 * @see HttpServlet#execute(HttpServletRequest request, HttpServletResponse response)
	 */
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<DeploymentForm> listOfDeplo=GetDeploymentToolOperation.getToolInforamtion();
    	List<DeploymentForm> deFromDaoImp=DeploymentDaoImpl.getDeployementInfo();
    	request.getSession().setAttribute("listOfDep",deFromDaoImp);
    	request.getRequestDispatcher("resultPage.jsp").forward(request, response);
	}
}
