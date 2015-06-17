import java.sql.Date;

/**
 * Sorting in such a way that only one element is picked and moved to the top
 * Selection sorting
 * 
 * @author santoshv
 *
 */


class B{
	
	java.util.Date fromDate ;
	java.util.Date ToDate;
	
	public void setFromDate(java.util.Date d) {
		this.fromDate = d;
	}
	
	public void setToDate(java.util.Date d) {
		this.ToDate = d;
	}
}

public class TopOrderSorting {

	static java.util.Date fromDate ;
	static java.util.Date ToDate;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		java.util.Date d = new java.util.Date(2013,5,8);
		java.util.Date d1 = new java.util.Date(2013,5,8);
		fromDate = d;
		ToDate = d1;
		B b = new B();
		b.setFromDate(d);
		b.setToDate(d1);
		
		// TODO Auto-generated method stub
		int a[] = {-2, 10, 10,3};
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println("");
		System.out.println("TopOrderSorting.main() " + get_order(a));
	}

	static int get_order(int input1[]) {
		int steps = 0;
		int length = input1.length;
		if (length == 0) {
			return steps;
		}
		int comparisons = length - 1;  // when index reaches last element all elements are sorted
		int target = -1;
		int max = input1[0];
		int secondMax = max;
		for (int i = 0; i < input1.length - 1; i++) {  // Find Max
			if (input1[i + 1] > max) {
				max = input1[i + 1];
			}
		}
		int min = input1[0];
		for (int i = 0; i < input1.length - 1; i++) {   //Find Min
			if (input1[i + 1] < min) {
				min = input1[i + 1];
			}
		}
		
		boolean condition = true;   //Dummy
		do {
			int i = 0;
			for (; i < comparisons; i++) {
				if (input1[i] <= input1[i + 1]) {
					continue;   //  continue as long order is fine
				}
				secondMax = min;   
				target = i+1;
				int actualMax = max;
				max = input1[i];   // Max is changed where bigger number is found
				// Logic to find "second max" w.r.t. bigger number from this point onwards where order is lost
				for (int j = i+1; j < input1.length; j++) {
					System.out.println("Element at "+input1[j]);
					if (input1[j] >= secondMax && input1[j] != actualMax && input1[j] < max){
						secondMax = input1[j];  //store second max
						target = j;   //store position
					}
				}//for
				break;  //surely you found target position to be moved

			}
			if (i == comparisons)   // once all elements are compared
				break;

			input1 = moveToTop(input1, target);
			steps++;
			System.out.print("Step :" + steps +" --> ");
			for (i = 0; i < input1.length; i++) {
				System.out.print(" " + input1[i]);
			}
			System.out.println("");
		}

		while (condition);
		// Write code here
		return steps;

	}

	static int[] moveToTop(int a[], int shiftPos) {
		int temp = a[shiftPos];
		for (int i = shiftPos; i > 0; i--) {
			a[i] = a[i - 1];
		}
		a[0] = temp;
		return a;
	}

}// end class