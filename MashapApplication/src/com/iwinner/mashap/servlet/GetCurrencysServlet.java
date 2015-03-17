package com.iwinner.mashap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iwinner.mashap.dao.CountryDaoImpl;
import com.iwinner.mashap.exceptions.DaoException;

public class GetCurrencysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetCurrencysServlet() {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		execute(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		execute(request, response);
	}

	public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		CountryDaoImpl cDao=new CountryDaoImpl();
		try {
			List list=cDao.getCurrencys();
			request.getSession().setAttribute("list",list);
			request.getRequestDispatcher("/WEB-INF/selectCurrency.jsp").forward(request,response);
		} catch (DaoException e) {
		}
		
	}
	public static void main(String[] args) {
		CountryDaoImpl cDao=new CountryDaoImpl();
		try {
			List list=cDao.getCurrencys();

		
		} catch (DaoException e) {
		}
	}
}
