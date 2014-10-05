package com.phoenixjcam.sorting.variants;

import java.util.Random;

/**
 * BubbleSort == SWAP sort
 * 
 * http://en.wikipedia.org/wiki/Bubble_sort
 * 
 * The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted. The
 * algorithm gets its name from the way smaller elements "bubble" to the top of the list. Because it only uses
 * comparisons to operate on elements, it is a comparison sort. Although the algorithm is simple, it is too slow for
 * practical use, even compared to insertion sort.
 * 
 * @author Bart88
 *
 */
public class BubbleSort
{
	private static void bubbleSort1()
	{
		int size = 10;

		Random randomizer = new Random();
		int[] data = new int[size];

		for (int i = 0; i < data.length; ++i)
		{
			data[i] = randomizer.nextInt(size);
			System.out.print(", " + data[i]);
		}

		for (int i = 0; i < data.length; ++i)
		{
			for (int j = i; j < data.length; ++j)
			{
				if (data[i] > data[j])
				{
					int tmp = data[i];
					data[i] = data[j]; // swap
					data[j] = tmp;
				}
			}
		}

		System.out.println();

		for (int i = 0; i < data.length; ++i)
			System.out.print(", " + data[i]);
	}

	private static void bubbleSort2()
	{
		int[] intArr =
		{ 4, 2, 0, 6, 1, 9, 7, 5, 3, 8 };

		for (int i = 0; i < intArr.length; i++)
		{
			System.out.print(intArr[i] + ", ");
		}

		for (int i = 0; i < intArr.length; i++)
		{
			for (int j = i; j < intArr.length; j++)
			{
				if (intArr[i] > intArr[j])
				{
					// swap
					int tmp = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = tmp;

					// System.out.println(); // to debug mode
				}
			}
		}

		System.out.println();

		for (int i = 0; i < intArr.length; i++)
		{
			System.out.print(intArr[i] + ", ");
		}

	}

	public static void main(String[] args)
	{
		bubbleSort2();
	}

}
