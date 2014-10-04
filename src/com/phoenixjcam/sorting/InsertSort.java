package com.phoenixjcam.sorting;

import java.util.Arrays;

public class InsertSort
{
	// in order 0 to 9
	private static void insertionSort(int[] intArr)
	{
		for (int i = 1; i < intArr.length; i++)
		{
			int valueToSort = intArr[i];
			int j = i;
			while (j > 0 && intArr[j - 1] > valueToSort)
			{
				intArr[j] = intArr[j - 1];
				j--;
			}
			intArr[j] = valueToSort;
		}
	}

	// in order 9 to 0
	public static void insertionSort2(int[] intArr)
	{
		int j; // the number of items sorted so far
		int key; // the item to be inserted
		int i;

		for (j = 1; j < intArr.length; j++) // Start with 1 (not 0)
		{
			key = intArr[j];
			for (i = j - 1; (i >= 0) && (intArr[i] < key); i--) // Smaller values are moving up
			{
				intArr[i + 1] = intArr[i];
			}
			intArr[i + 1] = key; // Put the key in its proper location
		}
	}

	public static void main(String[] args)
	{
		int[] intArr =
		{ 4, 8, 0, 6, 1, 9, 7, 5, 3, 2 };

		System.out.println("before " + Arrays.toString(intArr));

		insertionSort(intArr);
		//insertionSort2(intArr);

		System.out.print("after  " + Arrays.toString(intArr));
	}
}
