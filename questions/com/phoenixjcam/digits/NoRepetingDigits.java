package com.phoenixjcam.digits;

/**
 * print all numbers between 1 and a million - with no repeating digits
 * 
 * @author Bart88
 *
 */
public class NoRepetingDigits
{
	
	public static void noRepeat(int n)
	{
		int[] ar;

		for (int i = 1; i <= n; i++)
		{
			int flag = 0;
			ar = new int[10];
			int temp = i;

			while (temp != 0)
			{
				ar[temp % 10]++;

				if (ar[temp % 10] > 1)
				{
					flag = 1;
				}

				temp = temp / 10;
			}

			if (flag == 0)
			{
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args)
	{
		// change this number to million
		noRepeat(100);
	}

}
