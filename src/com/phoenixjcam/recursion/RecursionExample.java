package com.phoenixjcam.recursion;

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

	// great example of how the stack structure is working 
	private static class Factorial
	{
		public static int calculate(int num)
		{
			int result = 0;

			if (num == 0)
			{
				System.out.println("if (num == 0) " + num);
				return 1;
			}
			
			System.out.println("result " + result);
			System.out.println("num " + num);
			
			result = calculate(num - 1) * num;
			
			System.out.println("result " + result);
			System.out.println("num " + num);
			

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
