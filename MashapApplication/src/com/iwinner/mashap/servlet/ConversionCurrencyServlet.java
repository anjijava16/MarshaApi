package com.iwinner.mashap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iwinner.mashap.consumer.api.MarsherApi;
import com.iwinner.mashap.dao.CountryDaoImpl;
import com.mashape.unirest.http.HttpResponse;

/**
 * Servlet implementation class ConversionCurrencyServlet
 */
public class ConversionCurrencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConversionCurrencyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fromCurrency = request.getParameter("fromCurrency");
		String toCurrency = request.getParameter("toCurrency");
		String resultOfCurrency=null;
	System.out.println(fromCurrency+"  "+toCurrency);
		try {
			HttpResponse<String> result = MarsherApi.getCurrencyInfo(		fromCurrency, toCurrency);
			System.out.println(result.getBody().toString());
			resultOfCurrency=result.getBody().toString();
		} catch (Exception e) {
		}
		response.getWriter().write(resultOfCurrency);
	}
}
