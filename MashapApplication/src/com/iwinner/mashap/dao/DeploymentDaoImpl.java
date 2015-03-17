package com.iwinner.mashap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iwinner.mashap.form.DeploymentForm;
import com.iwinner.mashap.utils.DbUtils;
import com.iwinner.mashap.utils.MarshUpConstatnts;

public class DeploymentDaoImpl {

public void insertDeployment(List<DeploymentForm> deployementForm){
	
	Connection con=DbUtils.getConnection();
	try{
		PreparedStatement pStmt=con.prepareStatement(MarshUpConstatnts.INSERT_DEPLOYEMENT_QUERY);
		
			Iterator<DeploymentForm> it=deployementForm.iterator();
			while(it.hasNext()){
				DeploymentForm dForm=(DeploymentForm)it.next();
				pStmt.setString(1, dForm.getTags());
				pStmt.setString(2, dForm.getId());
				pStmt.setString(3, dForm.getLogo());
				pStmt.setString(4, dForm.getDetails());
				pStmt.setString(5, dForm.getWebsite());
				pStmt.setString(6, dForm.getName());
				Integer updateId=pStmt.executeUpdate();
				System.out.println("UpdateID is :::"+updateId);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
}
public static List<DeploymentForm> getDeployementInfo(){
	List<DeploymentForm> listDeployement=new ArrayList<DeploymentForm>();
	Connection con=DbUtils.getConnection();
	try{
		 PreparedStatement pStmt=con.prepareStatement(MarshUpConstatnts.SELECT_DEPLOYE_QUERY);
		 ResultSet rs=pStmt.executeQuery();
		 while(rs.next()){
				DeploymentForm dForm=new DeploymentForm();
				dForm.setLogo(rs.getString("logo"));
				dForm.setName(rs.getString("name"));
				dForm.setWebsite(rs.getString("website"));
				 listDeployement.add(dForm);
			 }
		
	}catch(Exception e){
		
	}
	return listDeployement;
}
}
