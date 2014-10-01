package com.phoenixjcam.collection.recursion;

/**
 *  factorial(5)  <br>
 *   factorial(4) <br>
 *     factorial(3) <br>
 *        factorial(2) <br>
 *           factorial(1) <br>
 *             return 1 <br>
 *           return 2*1 = 2 <br>
 *        return 3*2 = 6 <br>
 *     return 4*6 = 24 <br>
 *  return 5*24 = 120 <br>
 * 
 * 
 * 
 * @author Bart88
 *
 */
public class RecursionExample
{

	private static class Factorial
	{
		public static int calculate(int num)
		{
			int result;

			if (num == 0)
				return 1;

			result = calculate(num - 1) * num;

			return result;
		}
	}

	public static long factorial(long n)
	{
		if (n < 0)
			throw new RuntimeException("Underflow error in factorial");
		
		else if (n > 20)
			throw new RuntimeException("Overflow error in factorial");
		
		else if (n == 0)
			return 1;
		
		else
			return n * factorial(n - 1);
	}

	public static void main(String args[])
	{
		
		System.out.println(factorial(5));
		
		
		int res = Factorial.calculate(5);

		System.out.println("Factorial of 5 = " + res);

	}

}
