package com.iwinner.mashap.consumer.api;


import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import com.iwinner.mashap.dao.CountryDaoImpl;
import com.iwinner.mashap.utils.MarshUpConstatnts;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class GetCountrysInformation {

public static void main(String[] args) {
	try{
	HttpResponse<JsonNode> response=MarsherApi.getCountryApi();

	System.out.println(response.getBody());
	JSONArray jsonArray=new JSONArray(response.getBody().toString());
	int c=0;
	Map<String,String> map=new HashMap<String, String>();
	CountryDaoImpl cMap=new CountryDaoImpl();
	for(int i=0;i<jsonArray.length();i++){
    	 String timeZones=jsonArray.getJSONObject(i).get("timezones").toString();
	     String time=timeZones.substring(2,timeZones.length()-2);
	     String languages=jsonArray.getJSONObject(i).get("languages").toString();
	     String languagesCountry=languages.substring(1,languages.length()-1);
	     String lanLat=jsonArray.getJSONObject(i).get("latlng").toString();
	     String langLat=lanLat.substring(1, lanLat.length()-1);
		map.put(MarshUpConstatnts.COUNTRY_NAME, jsonArray.getJSONObject(i).get("name").toString());
		map.put(MarshUpConstatnts.COUNTRY_CAPITAL_NAME, jsonArray.getJSONObject(i).get("capital").toString());
		map.put(MarshUpConstatnts.COUNTRY_REGION_NAME, jsonArray.getJSONObject(i).get("region").toString());
		map.put(MarshUpConstatnts.COUNTRY_CURRENCY_NAME, jsonArray.getJSONObject(i).get("currency").toString());
		map.put(MarshUpConstatnts.COUNTRY_LANGUAGES, languagesCountry);
		map.put(MarshUpConstatnts.COUNTRY_CALLINGCODE, jsonArray.getJSONObject(i).get("callingcode").toString());
		map.put(MarshUpConstatnts.COUNTRY_NATIONALITY, jsonArray.getJSONObject(i).get("nationality").toString());
		map.put(MarshUpConstatnts.COUNTRY_TIMEZONES, time);
		map.put(MarshUpConstatnts.COUNTRY_POPULATION, jsonArray.getJSONObject(i).get("population").toString());
		map.put(MarshUpConstatnts.COUNTRY_ALPHA2CODE,jsonArray.getJSONObject(i).get("alpha2Code").toString());
		map.put(MarshUpConstatnts.COUNTRY_ALPHA3CODE, jsonArray.getJSONObject(i).get("alpha3Code").toString());
		map.put(MarshUpConstatnts.COUNTRY_GINI, jsonArray.getJSONObject(i).get("gini").toString());
		map.put(MarshUpConstatnts.COUNTRY_AREA,jsonArray.getJSONObject(i).get("area").toString());
		map.put(MarshUpConstatnts.COUNTRY_ALTRA_SPELLING, jsonArray.getJSONObject(i).get("altSpellings").toString());
		map.put(MarshUpConstatnts.COUNTRY_ISO_CODE, jsonArray.getJSONObject(i).get("isoNumericCode").toString());
		map.put(MarshUpConstatnts.LANLAT, langLat);
		cMap.insertCountryInsertion(map);//COUNTRY_LANGUAGES
	}

	
	
	System.out.println(map.size());
	//System.out.println(c);
	
	
		/*Map<String,String> map = new HashMap<String,String>();
    Iterator iter = jsonObj.keys();
    while(iter.hasNext()){
        String key = (String)iter.next();
        String value = jsonObj .getString(key);
        System.out.println(key+"  "+value);
        map.put(key,value);
    }
    */
	}catch(Exception e){
	  e.printStackTrace();	
	}

	}	
}
