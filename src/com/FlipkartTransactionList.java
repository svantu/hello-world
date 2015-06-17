package com;

import java.util.ArrayList;

public class FlipkartTransactionList implements Comparable<FlipkartTransactionList>{

	ArrayList<FlipkartTranaction> list = new ArrayList<>();
	

	int totalSold = 0;

	int itemId = -1;

	public FlipkartTransactionList(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void addItem(FlipkartTranaction t) {
		this.itemId = t.itemId;
		totalSold += t.getQuantity();
		list.add(t);
		// not required everytime
	}

	public int getTotalSold() {
		return totalSold;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return itemId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.itemId + " sold " + totalSold;
	}

	@Override
	public int compareTo(FlipkartTransactionList o) {
		// TODO Auto-generated method stub
		return this.getTotalSold() - o.getTotalSold();
	}

}
