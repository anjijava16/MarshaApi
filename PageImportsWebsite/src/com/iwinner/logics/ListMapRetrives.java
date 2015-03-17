package com.iwinner.logics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListMapRetrives {
public static void main(String[] args) {
	
	
	List listOfValues=new ArrayList();
	listOfValues.add("A");
	listOfValues.add("B");
	listOfValues.add("C");
	listOfValues.add("D");
	listOfValues.add("E");
	listOfValues.add("F");
	Iterator it=listOfValues.iterator();
	System.out.println(it);
	while(it.hasNext()){
		 Map adminDetailsMap = (Map) it.next();
         String adminStatus = (String) adminDetailsMap.get("adminuserstatus");
         System.out.println(adminStatus);
	}
	
}
}
