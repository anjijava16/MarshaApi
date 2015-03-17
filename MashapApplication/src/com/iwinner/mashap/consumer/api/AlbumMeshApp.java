package com.iwinner.mashap.consumer.api;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class AlbumMeshApp {
public static void main(String[] args)throws Exception {
	HttpResponse<String> response = Unirest.get("https://mager-spotify-web.p.mashape.com/search/1/album.json?q=anjaiahspr")
			.header("X-Mashape-Key", "Y3MxEWkOX3mshcvQ85SZCoIqucVMp1qRpjbjsn0TYnnY8c1fIR")
			.asString();
     System.out.println(response.getBody());
	
	System.out.println(response.toString());
	JSONObject jsonObj = new JSONObject(response.getBody());
	JSONArray jsonArr=jsonObj.getJSONArray("albums");//artists
	for(int i=0;i<jsonArr.length();i++){
		ArtistsBean aBean=new ArtistsBean();
		String href=jsonArr.getJSONObject(i).getString("href");
		String name=jsonArr.getJSONObject(i).getString("name");
		System.out.println(href+"   "+name);
	}

}
}
