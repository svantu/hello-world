package com;

public class SequenceNumber extends Thread{

	public void run() {
		System.out.println("I'm thread");
	}
	
	public static void main(String[] args) {
		SequenceNumber obj = new SequenceNumber();
		obj.start();
		System.out.println("SequenceNumber.main()");
		
	}
}
