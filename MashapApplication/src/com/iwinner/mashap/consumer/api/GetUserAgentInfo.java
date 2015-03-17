package com.iwinner.mashap.consumer.api;

import org.json.JSONObject;

//import com.google.gson.JsonObject;
import com.iwinner.mashap.form.UserAgentForm;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class GetUserAgentInfo {

	
	public static String getUserAgentInfo(){
		HttpResponse<JsonNode> response=MarsherApi.getPostUserInfo();
		try{
			JSONObject jsonObject =new JSONObject(response.getBody().toString());
			UserAgentForm uForm=new UserAgentForm();
			uForm.setMobileModel(jsonObject.get("mobile-model").toString());
			uForm.setBrowserName(jsonObject.get("browser-name").toString());
			uForm.setOperatingSystem(jsonObject.get("operating-system").toString());
			uForm.setMobileBrand(jsonObject.get("mobile-brand").toString());
			uForm.setMobileScreenHeight(jsonObject.get("mobile-screen-height").toString());
			uForm.setProducer(jsonObject.get("producer").toString());
			uForm.setType(jsonObject.get("type").toString());
			uForm.setMobileScreenWidth(jsonObject.get("mobile-screen-width").toString());
			uForm.setMobileBrowser(jsonObject.get("mobile-browser").toString());
			uForm.setIsMobile(jsonObject.get("is-mobile").toString());
			uForm.setVersion(jsonObject.get("version").toString());
            
			System.out.println(uForm.toString());
		}catch(Exception e){
			
		}
		
		return null;
	}
	public static void main(String[] args) {
		getUserAgentInfo();	
	}
}
