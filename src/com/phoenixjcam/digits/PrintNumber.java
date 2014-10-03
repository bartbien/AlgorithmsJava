package com.phoenixjcam.digits;

/**
 * Write a program that prints the numbers from 1 to 100. 
 * But for multiples of three print "Fizz" instead of the number 
 * and for the multiples of five print "Buzz". 
 * For numbers which are multiples of both three and five print "FizzBuzz".
 * 
 * @author Bart88
 *
 */
public class PrintNumber
{
	public static void main(String[] args)
	{
		//int a = 99 % 3;
		
		int size = 100;
		
		for (int i = 1; i <= size; i++)
		{
			int x = i % 3;
			int y = i % 5;
			
			//boolean valueX = x == 0;
			//boolean valueY = y == 0;
			
			if(x == 0 && y == 0)
			{
				System.out.println("FizzBuzz");
			}
			else if(x == 0)
			{
				System.out.println("Fizz");
			}
			else if(y == 0)
			{
				System.out.println("Buzz");
			}
			else
				System.out.println(i);
		}
	}
}
