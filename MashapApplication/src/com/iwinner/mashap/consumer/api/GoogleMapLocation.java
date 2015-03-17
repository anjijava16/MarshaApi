package com.iwinner.mashap.consumer.api;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.iwinner.mashap.utils.MarshUpConstatnts;

public class GoogleMapLocation {
	public Object startOperation() {
		try {
			HttpClient httpClient = new DefaultHttpClient();
			// HttpClient client = new HttpClient();
			HttpGet getRequest = new HttpGet(MarshUpConstatnts.GOOGLE_MAP_LOCATION);
			getRequest.addHeader("accept", "application/json");
			HttpResponse response = (HttpResponse) httpClient.execute(getRequest);
			//System.out.println(response.getEntity().getContent());
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				JSONObject jsonObj=new JSONObject(output);
				//System.out.println(jsonObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
		GoogleMapLocation fb = new GoogleMapLocation();
		fb.startOperation();
	}

}
