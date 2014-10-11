package com.phoenixjcam.searching.binary;


public class BinarySearch2
{

	public static void main(String[] args)
	{
		// Random randomizer = new Random();
		// int size = 20;
		// int[] intArray = new int[size];
		//
		// for (int i = 0; i < size; i++)
		// {
		// intArray[i] = randomizer.nextInt(30);
		// }
		// Arrays.sort(intArray);

		/**
		 * first index = 0;
		 * last index = 19;
		 */
		int intArray[] =
		{ 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 17, 18, 19, 20, 21, 22, 24, 27, 28, 29 };

		
		int key = 29;

		search(key, intArray);

	}

	private static int search(int key, int[] intArray)
	{
		int lenght = intArray.length;

		int min = 0;
		int max = lenght - 1;
		int subIndex = 0;
		int currentKey = intArray[subIndex];

		while (min <= max)
		{
			subIndex = min + ((max - min) / 2);
			currentKey = intArray[subIndex];

			if (key < currentKey)
			{
				max = subIndex + 1;
			}
			else if (key > currentKey)
			{
				min = subIndex + 1;
			}
			else
			{
				System.out.println(subIndex);
				return subIndex;
			}
		}

		return -1;
	}

}
