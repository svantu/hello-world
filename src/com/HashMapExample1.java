package com;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapExample1 {

	static Hashtable h = new Hashtable<Employee, Integer>();
	static HashMap map = new HashMap<Employee, Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		h.put(e5,new Integer(e5.getId()));   /// No nulls
		
	
		map.put(e, new Integer(e.getId()));
		map.put(e1, new Integer(e1.getId()));
		map.put(e2, new Integer(e2.getId()));
		map.put(e3, new Integer(e3.getId()));
		map.put(e4,new Integer(e4.getId()));
		map.put(e5,new Integer(e5.getId()));
		map.put(null,null);    //permits null
		
		Map synchronizedMap = Collections.synchronizedMap(map);  //synchronized map.
		
		System.out.println("HashMapExample1.main() Map "+map);
		System.out.println("HashMapExample1.main() table "+h);
		System.out.println("HashMapExample1.main() synchronised map "+synchronizedMap);
	}

}
