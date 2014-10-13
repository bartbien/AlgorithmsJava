package com.phoenixjcam.numbers.prime;
public class PrimeNumbers
{
	public static boolean prime(int testNumber)
	{
		for (int divider = 2; divider < testNumber; divider++)
		{
			int calculate = testNumber % divider;

			if (calculate == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args)
	{

		int range = 10;
		int primeNumbCounter = 0;

		for (int testNumber = 2; testNumber <= range; testNumber++)
		{
			if (prime(testNumber))
			{
				System.out.println(testNumber);
				primeNumbCounter++;
			}
		}

		System.out.println("Prime number less then " + range + ". Number of them = " + primeNumbCounter);
	}

}