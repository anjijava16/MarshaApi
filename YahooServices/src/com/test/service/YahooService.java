package com.test.service;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.test.yahoo.weather.Channel;
import com.test.yahoo.weather.Forecast;
import com.test.yahoo.weather.Item;
import com.test.yahoo.weather.Weather;

public class YahooService {

	/*
	 * // specify the host, protocol, and port HttpHost target = new
	 * HttpHost("weather.yahooapis.com", 80, "http");
	 * 
	 * // specify the get request HttpGet getRequest = new
	 * HttpGet("/forecastrss?p=INXX0358&u=f");
	 */
	public Weather findWeather(String woeid) {
		System.out.println("retrieve current data from Yahoo");
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(
				"http://weather.yahooapis.com/forecastrss?p=" + woeid + "&u=f",
				Weather.class);
	}

	/*
	 * @Scheduled(fixedDelay=60000) public void evict() {
	 * System.out.println("cache evicted"); }
	 */

	public static void main(String[] args) {
		YahooService ySer = new YahooService();
		Weather weather = ySer.findWeather("INXX0358");
		System.out.println(weather);
		Channel ch = weather.getChannel();
		System.out.println(ch.getDescription());
		System.out.println(ch.getTitle());
		Item it=ch.getItem();
		List<Forecast> lis=it.getForecasts();
		System.out.println("Size Of "+lis.size());
         for(Forecast fs:lis){
        	 System.out.println(fs.getDate()+"  "+fs.getHigh()+"  "+fs.getLow()+"  "+fs.getText());
         }
		System.out.println(ch.getItem());
	}
}
