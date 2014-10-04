package com.phoenixjcam.sorting;

import java.util.Random;

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

	public static void quickSort2()
	{
		Random randomizer = new Random();
		int[] data = new int[100];

		for (int i = 1; i < data.length; ++i)
		{
			data[i] = randomizer.nextInt(100);
			System.out.print(", " + data[i]);
		}

		quickSort(data, 0, data.length - 1);

		System.out.println();

		for (int i = 0; i < data.length; ++i)
			System.out.print(", " + data[i]);
	}

	public static void main(String[] args)
	{

	}

}
