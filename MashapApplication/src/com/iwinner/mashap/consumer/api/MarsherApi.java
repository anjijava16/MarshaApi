package com.iwinner.mashap.consumer.api;

import org.json.JSONArray;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class MarsherApi {

	public static HttpResponse<JsonNode> getCountryApi() throws Exception {
		HttpResponse<JsonNode> response = Unirest
				.get("https://restcountries.p.mashape.com/all")
				.header("X-Mashape-Key",
						"Y3MxEWkOX3mshcvQ85SZCoIqucVMp1qRpjbjsn0TYnnY8c1fIR")
				.asJson();
		return response;
	}
	public static HttpResponse<String> getCurrencyInfo(String fromCurrency,String toCurrency) throws Exception {
		HttpResponse<String> response = Unirest
				.get("https://currency-exchange.p.mashape.com/exchange?from="+fromCurrency+"&q=1&to="+toCurrency)
				.header("X-Mashape-Key",
						"Y3MxEWkOX3mshcvQ85SZCoIqucVMp1qRpjbjsn0TYnnY8c1fIR")
				.asString();
		return response;
	}
	public static HttpResponse<JsonNode> getPNRStatusForm() {
		HttpResponse<JsonNode> response=null;
		try{
			response= Unirest.get("https://indianrailways.p.mashape.com/index.php?pnr=6738954561")
				.header("X-Mashape-Key", "Y3MxEWkOX3mshcvQ85SZCoIqucVMp1qRpjbjsn0TYnnY8c1fIR")
				.header("Accept", "application/json")
				.asJson();
		}catch(Exception e){
			
		}
	          return response;	
	}
	
	public static HttpResponse<JsonNode>  getPostUserInfo(){
		HttpResponse<JsonNode> response=null;
		try{
		// These code snippets use an open-source library. http://unirest.io/java
		 response = Unirest.post("https://neutrinoapi-user-agent-info.p.mashape.com/user-agent-info")
		.header("X-Mashape-Key", "Y3MxEWkOX3mshcvQ85SZCoIqucVMp1qRpjbjsn0TYnnY8c1fIR")
		.header("Content-Type", "application/x-www-form-urlencoded")
		.header("Accept", "application/json")
		.field("user-agent", "Mozilla/5.0 (Linux; U; Android 1.6; ar-us; SonyEricssonX10i Build/R2BA026) AppleWebKit/528.5+ (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1")
		.asJson();
		}catch(Exception e){
		}
		return response;
	}
	
	public static HttpResponse<JsonNode> getDeployementTools(){
		HttpResponse<JsonNode> response=null;
		try {
			// These code snippets use an open-source library. http://unirest.io/java
			response= Unirest.get("https://ismaelc-apievangelist.p.mashape.com/data/tools.json")
			.header("X-Mashape-Key", "Y3MxEWkOX3mshcvQ85SZCoIqucVMp1qRpjbjsn0TYnnY8c1fIR")
			.header("Accept", "application/json")
			.asJson();
		} catch (Exception e) {
		}
		return response;
	}
	public static void main(String[] args)throws Exception {
		/*HttpResponse<String> res=getCurrencyInfo("MYR","INR");
		System.out.println(res.getBody());*/
		try{
			HttpResponse<JsonNode> response=MarsherApi.getCountryApi();
             JSONArray jArr=new JSONArray(response.getBody().toString());
             System.out.println("ArrayValue is "+jArr.length());
		//	System.out.println(response.getBody());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
