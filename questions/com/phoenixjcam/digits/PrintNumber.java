package com.phoenixjcam.digits;

/**
 * Write a program that prints the numbers from 1 to 100. But for multiples of three print "Fizz" instead of the number
 * and for the multiples of five print "Buzz". For numbers which are multiples of both three and five print "FizzBuzz".
 * 
 * @author Bart88
 *
 */
public class PrintNumber
{
	private static void test1()
	{// int a = 99 % 3;

		int size = 100;

		for (int i = 1; i <= size; i++)
		{
			int x = i % 3;
			int y = i % 5;

			// boolean valueX = x == 0;
			// boolean valueY = y == 0;

			if (x == 0 && y == 0)
			{
				System.out.println("FizzBuzz");
			}
			else if (x == 0)
			{
				System.out.println("Fizz");
			}
			else if (y == 0)
			{
				System.out.println("Buzz");
			}
			else
				System.out.println(i);
		}
	}

	private static void test2()
	{
		for (int i = 1; i < 101; ++i)
		{
			boolean printing = false;

			if (i % 3 == 0)
			{
				System.out.print("Fizz");
				printing = true;
			}

			if (i % 5 == 0)
			{
				System.out.print("Buzz");
				printing = true;
			}

			if (printing)
				System.out.println();

			else
				System.out.println(i);
		}
	}

	private static void test3()
	{
		int a1 = 1, a2 = 1;

		for (int i = 1; i < 101; ++i)
		{
			if (a1 == 3)
			{
				a1 = 1;
				System.out.print("Fizz");
			}
			else
				a1 += 1;

			if (a2 == 5)
			{
				a2 = 1;
				System.out.print("Buzz");
			}
			else
				a2 += 1;

			if (a1 == 3 && a2 == 5)
				System.out.println();

			else
				System.out.println(i);
		}
	}

	/**
	 * Check time between this two solutions of the same task.
	 */
	public static void performance()
	{
		//int count = Integer.MAX_VALUE - 1; // faster second solution 
		long count = 10000000L; // faster first solution 

		{
			long dd = 0;
			long t1 = System.currentTimeMillis();
			int a1 = 1, a2 = 1;

			for (int i = 1; i < count; ++i)
			{
				if (a1 == 3)
				{
					a1 = 1;
					dd += 1;
					// System.out.print("Fizz");
				}
				else
					a1 += 1;

				if (a2 == 5)
				{
					a2 = 1;
					dd += 1;
					// System.out.print("Buzz");
				}
				else
					a2 += 1;

				if (a1 == 3 && a2 == 5)
					dd += 1;
				// System.out.println();

				else
					dd += 2;
				// System.out.println(i);
			}

			long t2 = System.currentTimeMillis();
			System.out.println(t2 - t1);
		}

		{
			long dd = 0;
			long t1 = System.currentTimeMillis();

			for (int i = 1; i < count; ++i)
			{
				boolean printing = false;

				if (i % 3 == 0)
				{
					// System.out.print("Fizz");
					dd += 1;
					printing = true;
				}

				if (i % 5 == 0)
				{
					// System.out.print("Buzz");
					dd += 1;
					printing = true;
				}

				if (printing)
					dd += 1;
				// System.out.println();

				else
					dd += 2;
				// System.out.println(i);
			}

			long t2 = System.currentTimeMillis();
			System.out.println(t2 - t1);
		}
	}

	public static void main(String[] args)
	{
		// test1();
		// test2();
		// test3();
		
		performance();
	}
}
