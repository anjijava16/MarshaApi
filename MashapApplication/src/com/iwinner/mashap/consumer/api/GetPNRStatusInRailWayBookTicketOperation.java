package com.iwinner.mashap.consumer.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.iwinner.mashap.form.BookingStatusForm;
import com.iwinner.mashap.form.PNRJounrneyDeteailsForm;
import com.iwinner.mashap.form.PNRStatusForm;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class GetPNRStatusInRailWayBookTicketOperation {
	public static String getPNRStatus(){
		PNRStatusForm pStatusForm=new PNRStatusForm();
		PNRJounrneyDeteailsForm pJourenyDe=new PNRJounrneyDeteailsForm();
		BookingStatusForm bStatusForm=new BookingStatusForm();
		try{
		HttpResponse<JsonNode> pnrResponse=MarsherApi.getPNRStatusForm();
		JSONObject jsonObj=new JSONObject(pnrResponse.getBody().toString());
		pStatusForm.setLastUpdated(jsonObj.get("lastUpdated").toString());
		pStatusForm.setPnr(jsonObj.getString("pnr"));//chartingStatus
		pStatusForm.setChartingStatus(jsonObj.get("chartingStatus").toString());
		List<PNRJounrneyDeteailsForm> pnrJourneyDeatils=new ArrayList<PNRJounrneyDeteailsForm>();
		List<BookingStatusForm> bookingStatusForm=new ArrayList<BookingStatusForm>();
		JSONObject journeyDetails=new JSONObject(jsonObj.get("journeyDetails").toString());
		pJourenyDe.setToAddress(journeyDetails.get("to").toString());
		pJourenyDe.setBoardingPoint(journeyDetails.get("boardingPoint").toString());
		pJourenyDe.setBoardingDate(journeyDetails.get("boardingDate").toString());
		pJourenyDe.setReservedUpto(journeyDetails.get("reservedUpto").toString());
		pJourenyDe.setClassId(journeyDetails.get("class").toString());
		pJourenyDe.setFrom(journeyDetails.get("from").toString());
		pJourenyDe.setTrainName(journeyDetails.get("trainNumber").toString());
		pJourenyDe.setTrainNumber(journeyDetails.get("trainName").toString());
		pnrJourneyDeatils.add(pJourenyDe);
		JSONArray bookingStatus=new JSONArray(jsonObj.get("bookingStatus").toString());
		for(int i=0;i<bookingStatus.length();i++){
			bStatusForm.setBookingStatus(bookingStatus.getJSONObject(i).get("bookingStatus").toString());
			bStatusForm.setCurrentStatus(bookingStatus.getJSONObject(i).get("currentStatus").toString());
			bStatusForm.setPassengerNo(bookingStatus.getJSONObject(i).get("passengerNo").toString());
			bookingStatusForm.add(bStatusForm);	
		}
		pStatusForm.setJounryDetailsForm(pnrJourneyDeatils);
		pStatusForm.setBookingStatus(bookingStatusForm);
		
		System.out.println("PStatusForm ::::+++>>>>"+pStatusForm.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
public static String getPntStatus(){
	try{
	// These code snippets use an open-source library. http://unirest.io/java
	HttpResponse<JsonNode> response = Unirest.get("https://indianrailways.p.mashape.com/index.php?pnr=6738954561")
	.header("X-Mashape-Key", "Y3MxEWkOX3mshcvQ85SZCoIqucVMp1qRpjbjsn0TYnnY8c1fIR")
	.header("Accept", "application/json")
	.asJson();
	System.out.println(response.getBody().toString());
	JSONObject jsonObj = new JSONObject(response.getBody().toString());
	System.out.println(jsonObj.get("lastUpdated"));
	System.out.println("PNR=["+jsonObj.get("pnr")+"]");
	JSONObject journeyDetails=new JSONObject(jsonObj.get("journeyDetails").toString());  //bookingStatus
	System.out.println("Borading Point::"+journeyDetails.get("boardingPoint"));
        System.out.println(jsonObj.get("bookingStatus"));
	
        
        System.out.println("==============================#############");
        JSONArray jsonArray=new JSONArray(jsonObj.get("bookingStatus").toString());
	System.out.println("JSONArray value is :::>>>>>>>>>>>>>"+jsonArray);
	Map<String,String> map=new HashMap<String, String>();
	for(int i=0;i<jsonArray.length();i++){
		 String passengerNo=jsonArray.getJSONObject(i).get("passengerNo").toString();
		 String currentStatus=jsonArray.getJSONObject(i).get("currentStatus").toString();
		 String bookingStatus=jsonArray.getJSONObject(i).get("bookingStatus").toString();
		 System.out.println(passengerNo+" "+currentStatus+" "+bookingStatus);
	}
	//System.out.println("Booking Status:::"+bookingStatus.get("bookingStatus"));
	/*JSONArray jArray=jsonObj.getJSONArray("journeyDetails");
	for(int i=0;i<jArray.length();i++){
		System.out.println(jArray.get(i));
	}*/
     System.out.println("Length of JsonObj===["+jsonObj.length()+"]");
	String jA=jsonObj.getString("lastUpdated");
    System.out.println(jA);
	System.out.println("========");
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
}
public static void main(String[] args) {
	//getPntStatus();
	getPNRStatus();

}
}
