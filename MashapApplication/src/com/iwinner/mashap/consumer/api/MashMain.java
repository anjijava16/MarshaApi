package com.iwinner.mashap.consumer.api;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class MashMain {
	public static void main(String[] args) throws Exception {
		HttpResponse<String> response = Unirest
				.get("https://mager-spotify-web.p.mashape.com/search/1/artist.json?q=Justin%2BTimberlake")
				.header("X-Mashape-Key",
						"Y3MxEWkOX3mshcvQ85SZCoIqucVMp1qRpjbjsn0TYnnY8c1fIR")
				.asString();

		System.out.println(response.toString());
		System.out.println(response.getBody());
		JSONObject jsonObj = new JSONObject(response.getBody());
		JSONArray jsonArr=jsonObj.getJSONArray("artists");
		for(int i=0;i<jsonArr.length();i++){
			ArtistsBean aBean=new ArtistsBean();
			String href=jsonArr.getJSONObject(i).getString("href");
			String name=jsonArr.getJSONObject(i).getString("name");
			String popularity=jsonArr.getJSONObject(i).getString("popularity");
			aBean.setHref(href);
			aBean.setName(name);
			aBean.setPopularity(popularity);
			
			//System.out.println(href+"   "+name+"   "+popularity);
		}
		
		//System.out.println(response.getBody());

	}
}
