package com;

/**
 * Transaction structure
 * @author santoshv
 *
 */
public class FlipkartTranaction {
		int quantity;
		 
		 int itemId;
		 
		 String description;
		 
		 public FlipkartTranaction(int quantity, int itemId, String desc){
			 this.itemId = itemId;
			 this.description = desc;
			 this.quantity = quantity;
		 }
		 
		 public Integer getItemId(){
			 return itemId;
		 }
		 
		 Integer getQuantity(){
			 return quantity;
		 }

		 @Override
		public String toString() {
		// TODO Auto-generated method stub
		return itemId+" -> "+quantity;
		}

}
