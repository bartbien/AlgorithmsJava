package com.phoenixjcam.sorting.simply;

import java.util.Arrays;

public class SelectionSort
{
	public static void selectionSort(int[] arr)
	{

		int i, j, minIndex, tmp;

		int n = arr.length;

		for (i = 0; i < n - 1; i++)
		{

			minIndex = i;

			for (j = i + 1; j < n; j++)

				if (arr[j] < arr[minIndex])

					minIndex = j;

			if (minIndex != i)
			{

				tmp = arr[i];

				arr[i] = arr[minIndex];

				arr[minIndex] = tmp;

			}

		}

	}
	
	public static void main(String[] args)
	{
		System.out.println("SelectionSort");
		
		int[] intArr =
		{ 4, 8, 0, 6, 1, 9, 7, 5, 3, 2 };

		System.out.println("before " + Arrays.toString(intArr));

		selectionSort(intArr);
		//insertionSort2(intArr);

		System.out.print("after  " + Arrays.toString(intArr));
	}
	
}
