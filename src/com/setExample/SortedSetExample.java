package com.setExample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import com.*;

class TransactionComparator implements Comparator<FlipkartTransactionList>{

	@Override
	public int compare(FlipkartTransactionList o1, FlipkartTransactionList o2) {
		return o1.getTotalSold() - o2.getTotalSold();
	}
	
}

public class SortedSetExample {

	/**
	 * Set allows unique elements - no duplicates 
	 * Both HashSet and TreeSet are not synchronised
	 * 
	 * Use when Sorting is required
	 * 
	 * TreeSet doesn't allow null while hashSet does allow
	 * 
	 * Fail-fast Iterators 
	 * 
	 * 
	 */
	static TreeSet<FlipkartTransactionList> set = new TreeSet(/*new TransactionComparator()*/); 
	//Treeset Element
	static NavigableSet<FlipkartTransactionList> nSet = null;
	static void addTransactions(FlipkartTranaction tr){
		if(set.isEmpty()){
			System.out.println("SortedSetExample.addTransactions() Empty "+tr);
			FlipkartTransactionList list = new FlipkartTransactionList(tr.getItemId());
			list.addItem(tr);
			set.add(list);
			return;
		}
		FlipkartTransactionList list = null;
		boolean found = false;
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			list = (FlipkartTransactionList) iterator.next();
			if(list.getItemId() == tr.getItemId()){
				list.addItem(tr);
				System.out.println("SortedSetExample found list "+tr);
				found = true;
				break;
			}
		}
		if(found){
			set.add(list);
		}else{
			System.out.println("Adding new list for "+list);
			list = new FlipkartTransactionList(tr.getItemId());
			list.addItem(tr);
			set.add(list);
		}
	}
	
	
	static void printTopTransaction(int topItems){
		int i = 1;
		for (Iterator iterator = nSet.iterator(); iterator.hasNext();) {
			FlipkartTransactionList list = (FlipkartTransactionList) iterator.next();
			System.out.println("Top item "+ i +" "+list );
			i++;
			if(i > topItems) break;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		addTransactions(new FlipkartTranaction(3,1001,"Soaps"));
		addTransactions(new FlipkartTranaction(2,1001,"Soaps"));
		addTransactions(new FlipkartTranaction(2,1001,"Soaps"));
		addTransactions(new FlipkartTranaction(2,1001,"Soaps"));
		
		
		addTransactions(new FlipkartTranaction(5,1002,"cakes"));
		addTransactions(new FlipkartTranaction(2,1002,"cakes"));
		
		addTransactions(new FlipkartTranaction(6,1003,"Coke"));
		addTransactions(new FlipkartTranaction(8,1003,"Coke"));
		
		addTransactions(new FlipkartTranaction(15,1004,"sandal"));
		
		addTransactions(new FlipkartTranaction(6,1005,"Organe"));
		
		addTransactions(new FlipkartTranaction(12,1006,"Coke"));
		
		nSet = set.descendingSet();
		printTopTransaction(3);
		
	}

}
