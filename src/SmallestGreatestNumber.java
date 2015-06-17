import java.util.ArrayList;

/**
 * Problem defined at TechGig, 80% pass rate achieved. 
 * @author santoshv
 *
 */
public class SmallestGreatestNumber {

	/**
	 * @param args
	 */
	
	static long  LARGE = 1000000000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 2345;
		int smallestGreatest = -1;
		int result = number;
		int multiplcationStep = 0;
		int additionStep = 0;
		
		int multiplicationResult = 0, additionResult = 0;
		
		if(number < 0 ) {
			System.out.println("Smallest greatest number is : "+smallestGreatest);
			return;
		}
		
		do{
			result = muliplication(result);
			multiplcationStep++;
			
		}while( result > 9);
//		System.out.println("SmallestGreatestNumber.main() "+multiplcationStep);
//		System.out.println("SmallestGreatestNumber.main() "+ muliplication(number));
//		System.out.println("SmallestGreatestNumber.main() "+ addition(number));
		multiplicationResult = result;
		result = number;
		do{
			result = addition(result);
			additionStep++;
		}while( result > 9);
		additionResult = result;
//		System.out.println("SmallestGreatestNumber add step "+ additionStep);
		smallestGreatest = checkCondition(multiplcationStep, additionStep, ++number, multiplicationResult, additionResult);
		System.out.println("Smallest greatest number is : "+ smallestGreatest);
	}
	
	
	static int checkCondition(int i, int j, int number, int multiplicationResult, int additionResult) {

		while (number < LARGE) {
			// System.out.println("SmallestGreatestNumber.checkCondition() "+number);
			int result = number;
			int multiplcationStep = 0;
			int multiresult = 0;
			int additionStep = 0;
			do {
				result = muliplication(result);
				// System.out.println("SmallestGreatestNumber result mutipilcation "+result);
				multiplcationStep++;

			} while (result > 9);
			// System.out.println("multiplcationStep "+multiplcationStep);
			multiresult = result;
			result = number;
			do {
				result = addition(result);
				// System.out.println("add result "+result);
				additionStep++;
			} while (result > 9);

			// System.out.println("additionStep "+additionStep);
			if ((multiplcationStep <= i) & (additionStep <= j) & (multiplicationResult == multiresult) & (additionResult == result))
				return number;

			number++;

		}

		return -1;
	}

	static int muliplication(int n) {
		int mod = 0;
		int product = 1;
		if (n <= 0)
			return -1;

		while (n != 0) {
			mod = n % 10;
			n = n / 10;
			product = product * mod;
			if (product == 0)
				break;

		}

		return product;
	}

	static int addition(int n) {
		int mod = 0;
		int sum = 0;

		if (n <= 0)
			return -1;

		while (n != 0) {
			mod = n % 10;
			n = n / 10;
			sum = sum + mod;
		}

		return sum;

	}	
	
}
