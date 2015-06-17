package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

 class Employee {
	int id;
	String name;
	public Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	public int getId(){
		return id;
	}
	
	@Override
	public String toString() {
		String s = name;
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null || !(obj instanceof Employee)) return false;
		
		Employee e = (Employee)obj;
		if(this.id == e.id && this.name.equals(e.name)){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println("Employee.hashCode() "+this.id+ " -> "+this.id * this.name.hashCode());
		return this.id * this.name.hashCode(); // or can remain same throughout say return 0 always.
	}
	
}

 
 class Transactions implements Comparator<Transactions>{
	 
	 int quantity;
	 
	 int itemId;
	 
	 String description;
	 
	 public Transactions(int quantity, int itemId, String desc){
		 this.itemId = itemId;
		 this.description = desc;
		 this.quantity = quantity;
	 }
	 
	 Integer getItemId(){
		 return itemId;
	 }
	 
	 public int hashCode() {
			// TODO Auto-generated method stub
			System.out.println("transactions.hashCode() "+this.quantity+ " -> "+this.quantity );
			return this.quantity; // or can remain same throughout say return 0 always.
	}
	 
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.itemId+" Q= "+this.quantity+" "+description;
	}

	@Override
	public int compare(Transactions o1, Transactions o2) {
		// TODO Auto-generated method stub

		if (o1.getItemId() < o2.getItemId()) {
			return -1;
		}
		if (o1.getItemId() > o2.getItemId()) {
			return 1;
		}
		return 0;
	}

 }

 
 
public class HashTableCompare {
	static Hashtable h = new Hashtable<Employee, Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Employee e = new Employee(01, "santosh");
		Employee e1 = new Employee(02, "sarita");
		Employee e2 = new Employee(03, "satish");
		Employee e3 = new Employee(04, "Aron");
		Employee e4 = new Employee(05, "mem");
		Employee e5 = new Employee(10, "sarita");
		
		h.put(e, new Integer(e.getId()));
		h.put(e1, new Integer(e1.getId()));
		h.put(e2, new Integer(e2.getId()));
		h.put(e3, new Integer(e3.getId()));
		h.put(e4,new Integer(e4.getId()));
		h.put(e5,new Integer(e5.getId()));
		
		
		
		System.out.println("HashTable Content is "+ h);
		
		System.out.println("Fetched details from database "+h.get(new Employee(10, "sarita")));
		System.out.println("Fetched details from database "+h.get(new Employee(0, "sarita")));
		System.out.println("Fetched details from database "+h.get(new Employee(2, "sarita")));
		
		Transactions t1 = new Transactions(18, 1245, "shaver");
		Transactions t2 = new Transactions(07, 1264, "soap");
		Transactions t3 = new Transactions(4, 453, "cleanser");
		Transactions t4 = new Transactions(10, 1245, "shaver");
		Transactions t5 = new Transactions(5, 453, "shaver");
		
		List<Transactions> list = new ArrayList<Transactions>();
		
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);
		
		Transactions comparator = new Transactions(-1, -1, null); // Same class implements comparator ideally should be different
		
		System.out.println("HashTableCompare.main() Map ");
		Collections.sort(list, comparator);
		
		
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Transactions txn = (Transactions) iterator.next();
			System.out.println("HashTableCompare.main() "+txn.toString());
		}
		
		
		
	}

}
