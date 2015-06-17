package com;

public class lightHouse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nCycle=4;

		//Size of bulbs
		boolean a[] = new boolean[12];
		//Set all glowing
		for (int i = 1; i < a.length; i++) {
			a[i]=true;
		}
		
		//from 2..n
		for(int j=2;j<=nCycle;j++){   // for nCycle times
			int index = 1;
			for (int i = 2; i < a.length; index++) {
				i = index * j;   // Multiple of J
				//System.out.println("lightHouse.main() index "+i);
				if(i >= a.length) break;
				a[i]=!a[i]; // toggle
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			if(a[i])
				System.out.println("lightHouse.main() "+i+" "+ a[i]);
			
		}
	}

}
