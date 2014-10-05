package com.phoenixjcam.sorting.efficient;

import java.util.Arrays;

public class QuickSort
{
	private static int partition(int arr[], int left, int right)
	{
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j)
		{
			while (arr[i] < pivot)
				i++;

			while (arr[j] > pivot)
				j--;

			if (i <= j)
			{
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;

				i++;
				j--;
			}
		}

		return i;
	}

	private static void quickSort(int arr[], int left, int right)
	{
		int index = partition(arr, left, right);

		if (left < index - 1)
			quickSort(arr, left, index - 1);

		if (index < right)
			quickSort(arr, index, right);
	}

	public static void main(String[] args)
	{
		System.out.println("QuickSort");

		int[] intArr =
		{ 4, 8, 0, 6, 1, 9, 7, 5, 3, 2 };

		System.out.println("before " + Arrays.toString(intArr));

		quickSort(intArr, 0, intArr.length - 1);
		// insertionSort2(intArr);

		System.out.print("after  " + Arrays.toString(intArr));
	}

}
