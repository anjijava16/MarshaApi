package com.iwinner.mashap.consumer.api;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class GetStationInfoMarshAppOperation {
	public static String getStationInfo() {
		try {
			// These code snippets use an open-source library.
			// http://unirest.io/java
			HttpResponse<JsonNode> response = Unirest
					.get("https://indianrailways.p.mashape.com/findstations.php?station=delhi")
					.header("X-Mashape-Key",
							"Y3MxEWkOX3mshcvQ85SZCoIqucVMp1qRpjbjsn0TYnnY8c1fIR")
					.header("Accept", "application/json").asJson();
			JSONObject jsonObj = new JSONObject(response.getBody().toString());
			JSONArray jsonArr = jsonObj.getJSONArray("stations");
			for (int i = 0; i < jsonArr.length(); i++) {
				String stationCode=jsonArr.getJSONObject(i).getString("stationCode");
				String stationName=jsonArr.getJSONObject(i).getString("stationName");
				System.out.println("stationCode::[="+stationCode+"]"+ ".stationName: =[ "+stationName+"]");
			}
		} catch (Exception e) {

		}
		return null;
	}

	public static void main(String[] args) {
		getStationInfo();
	}
}
