package com.iwinner.mashap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.iwinner.mashap.exceptions.DaoException;
import com.iwinner.mashap.utils.DbUtils;
import com.iwinner.mashap.utils.MarshUpConstatnts;

public class CountryDaoImpl {

public void insertCountryInsertion(Map<String,String> map)throws DaoException{
	
	Connection con=DbUtils.getConnection();
	try{
	PreparedStatement pStmt=con.prepareStatement(MarshUpConstatnts.INSERT_QUERY);
	pStmt.setString(1, map.get(MarshUpConstatnts.COUNTRY_NAME));
	pStmt.setString(2, map.get(MarshUpConstatnts.COUNTRY_CAPITAL_NAME));
	pStmt.setString(3, map.get(MarshUpConstatnts.COUNTRY_REGION_NAME));
	pStmt.setString(4, map.get(MarshUpConstatnts.COUNTRY_CURRENCY_NAME));
	pStmt.setString(5, map.get(MarshUpConstatnts.COUNTRY_LANGUAGES));
	pStmt.setString(6, map.get(MarshUpConstatnts.COUNTRY_CALLINGCODE));
	pStmt.setString(7, map.get(MarshUpConstatnts.COUNTRY_ALPHA2CODE));
	pStmt.setString(8, map.get(MarshUpConstatnts.COUNTRY_ALPHA3CODE));
	pStmt.setString(9, map.get(MarshUpConstatnts.COUNTRY_NATIONALITY));
	pStmt.setString(10, map.get(MarshUpConstatnts.COUNTRY_TIMEZONES));
	pStmt.setString(11, map.get(MarshUpConstatnts.COUNTRY_POPULATION));
	pStmt.setString(12, map.get(MarshUpConstatnts.COUNTRY_GINI));
	pStmt.setString(13, map.get(MarshUpConstatnts.COUNTRY_AREA));
	pStmt.setString(14, map.get(MarshUpConstatnts.COUNTRY_ALTRA_SPELLING));
	pStmt.setString(15, map.get(MarshUpConstatnts.COUNTRY_ISO_CODE));
	pStmt.setString(16, map.get(MarshUpConstatnts.LANLAT));
	int x=pStmt.executeUpdate();
    System.out.println("Count "+x);
	}catch(Exception e){
		e.printStackTrace();
	}
}
public List getCurrencys()throws DaoException{
	List listOfCurrencys=new ArrayList();
	Connection con=DbUtils.getConnection();
	try {
	 PreparedStatement pStmt=con.prepareStatement(MarshUpConstatnts.SELECT_CURRENCY);
	 ResultSet rs=pStmt.executeQuery();
	 while(rs.next()){
		 String currency=rs.getString("currency");
		 if(currency!=null&currency.length()!=0){
		 listOfCurrencys.add(currency);
		 }
	 }
	} catch (Exception e) {
	}
	return listOfCurrencys;
}
}
