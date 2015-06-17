package com;

import java.util.LinkedList;
import java.util.ListIterator;


public class LinkListExamples {
 
	public static void main(String[] args) {
	       LinkedList<String> linkedList = new LinkedList<String>();
	        linkedList.add("eBay");
	        linkedList.add("Paypal");
	        linkedList.add("Google");
	        linkedList.add("Yahoo");
	        linkedList.add("IBM");
	        linkedList.add("Facebook");
 
	        // ListIterator approach
	        System.out.println("ListIterator Approach: ");
	        ListIterator<String> listIterator = linkedList.listIterator();
	        while (listIterator.hasNext()) {
	        	String str = (String)listIterator.next();
	        	if(str.equals("Paypal")){
	        		linkedList.remove("Paypal");
	        		System.out.println("removed paypal");
	        		//listIterator = linkedList.listIterator();
	        		break;
	        	}
	        	System.out.println(str);
	        	//listIterator = linkedList.listIterator();
	        	
	        }
 
	        System.out.println("\nLoop Approach: ");
	        // Traditional for loop approach
	        for (int i = 0; i < linkedList.size(); i++) {
	            System.out.println(linkedList.get(i));
	        }
	        
	        
	}
}