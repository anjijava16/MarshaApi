package com.iwinner.mashap.consumer.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.iwinner.mashap.dao.DeploymentDaoImpl;
import com.iwinner.mashap.form.DeploymentForm;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class GetDeploymentToolOperation {

	public static List<DeploymentForm> getToolInforamtion(){
		
		DeploymentDaoImpl dImpl=new DeploymentDaoImpl();
		List<DeploymentForm> listOfDeploymentForm=new ArrayList<DeploymentForm>();
		try {
			HttpResponse<JsonNode> response =MarsherApi.getDeployementTools();
			JSONObject jsonObj=new JSONObject(response.getBody().toString());
			JSONArray jsonArray=new JSONArray(jsonObj.get("tools").toString());
			for(int i=0;i<jsonArray.length();i++){
				DeploymentForm dForm=new DeploymentForm();
				dForm.setId(jsonArray.getJSONObject(i).get("id").toString());
				dForm.setLogo(jsonArray.getJSONObject(i).get("logo").toString());
				dForm.setDetails(jsonArray.getJSONObject(i).get("details").toString());
				dForm.setName(jsonArray.getJSONObject(i).get("name").toString());
				dForm.setTags(jsonArray.getJSONObject(i).get("tags").toString());
				dForm.setWebsite(jsonArray.getJSONObject(i).get("website").toString());
				listOfDeploymentForm.add(dForm);
			}
			dImpl.insertDeployment(listOfDeploymentForm);			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return listOfDeploymentForm;
	}
			
	public static void main(String[] args) {
		List<DeploymentForm> deployementForm=getToolInforamtion();
		/*for(int i=0;i<deployementForm.size();i++){
			Iterator<DeploymentForm> it=deployementForm.iterator();
			while(it.hasNext()){
				DeploymentForm dForm=(DeploymentForm)it.next();
				System.out.println(dForm.getId());
			}
		}*/
	}
}
