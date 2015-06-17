package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;




/**
 * Holds a list of transactions for an item
 * @author santoshv
 *
 */
class TxnList {

	ArrayList<FlipkartTranaction> list = new ArrayList<>();

	int totalSold = 0;

	int itemId = -1;

	TxnList(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void addItem(FlipkartTranaction t) {
		totalSold += t.getQuantity();
		list.add(t);
		// not required everytime
	}

	int getTotalSold() {
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

}

class ItemComparator implements Comparator<TxnList>{
	@Override
	public int compare(TxnList o1, TxnList o2) {
		// TODO Auto-generated method stub
		if(o1.getItemId() < o2.getItemId())
			return -1;
		else if(o1.getItemId() > o2.getItemId())
			return 1;
		return 0;
	}
}

class SaleComparator implements Comparator<TxnList>{
	@Override
	public int compare(TxnList o1, TxnList o2) {
		// TODO Auto-generated method stub
		if(o1.getTotalSold() < o2.getTotalSold())
			return -1;
		else if(o1.getTotalSold() > o2.getTotalSold())
			return 1;
		return 0;
	}
}

/**
 * Main class
 * @author santoshv
 *
 */
public class TopTenTxns {

	static  int TOPLIST =3;
	
	static ArrayList<TxnList> topTen = null;
	
	static ArrayList lowerSales = new ArrayList<TxnList>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		topTen = new ArrayList();
		addATxn(new FlipkartTranaction(4, 1, "Soaps"));
		addATxn(new FlipkartTranaction(8, 2, "Shampo"));
		addATxn(new FlipkartTranaction(2, 1, "Soaps"));
		addATxn(new FlipkartTranaction(6, 1, "Soaps"));
		addATxn(new FlipkartTranaction(6, 3, "Soaps"));
		addATxn(new FlipkartTranaction(3, 3, "Soaps"));
		addATxn(new FlipkartTranaction(3, 4, "cake"));
		addATxn(new FlipkartTranaction(1, 4, "cake"));
		addATxn(new FlipkartTranaction(9, 4, "cake"));
		addATxn(new FlipkartTranaction(1, 2, "Shampo"));
		addATxn(new FlipkartTranaction(1, 2, "Shampo"));
		
		Collections.sort(topTen,new SaleComparator());
		
		System.out.println("Top sales "+topTen);
		System.out.println("Lower sale "+lowerSales);
	}
	
	
	static void addATxn(FlipkartTranaction t){
		if(topTen.size() < 1){  // Add first element 
			TxnList temp = new TxnList(t.getItemId());
			temp.addItem(t);
			topTen.add(temp);
			return;
		}
		else{   // Search in top list
			TxnList temp2 = null;
			boolean found = false;
			for (Iterator iterator = topTen.iterator(); iterator.hasNext();) {
				TxnList type = (TxnList) iterator.next();
				if(type.getItemId() == t.getItemId()){
					type.addItem(t);
					found = true;
					break;
				}
			
			}
			if(found) return;  // Found the item in top list and returned
			if(topTen.size() <= TOPLIST -1 ){   // Should anyway end up going to top list as it's less than top items
				temp2 =  new TxnList(t.getItemId());
				temp2.addItem(t);
				topTen.add(temp2);
				return;
			}
			
		}
		//lower sales
		TxnList type = null;
		boolean foundInLowerList = false;
		for (Iterator iterator = lowerSales.iterator(); iterator.hasNext();) {
			 type = (TxnList) iterator.next();
			if(type.getItemId() == t.getItemId()){
				type.addItem(t);
				foundInLowerList = true;
				break;
			}
		}
		if(foundInLowerList){
			Collections.sort(topTen,new SaleComparator());
			TxnList topLow = (TxnList)topTen.get(0);
			System.out.println("Top Low "+topLow);
			TxnList topHighest = (TxnList)topTen.get(topTen.size()-1);
			System.out.println("Top item "+topHighest);
			if(type.getTotalSold() > topLow.getTotalSold()){
				lowerSales.remove(type);
				topTen.add(type);
				topTen.remove(topLow);
				lowerSales.add(topLow);
			}
		}else{
			TxnList newItem = new TxnList(t.getItemId());
			newItem.addItem(t);
			lowerSales.add(newItem);
		}
		
	}

}
