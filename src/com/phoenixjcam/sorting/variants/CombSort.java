package com.phoenixjcam.sorting.variants;

import java.util.Arrays;

public class CombSort
{
	private static int newGap(int gap)
	{
		gap = gap * 10 / 13;

		if (gap == 9 || gap == 10)
			gap = 11;

		if (gap < 1)
			return 1;

		return gap;
	}

	private static void combSort(int intArr[])
	{
		int gap = intArr.length;
		boolean swapped;

		do
		{
			swapped = false;
			gap = newGap(gap);

			for (int i = 0; i < (intArr.length - gap); i++)
			{
				if (intArr[i] > intArr[i + gap])
				{
					swapped = true;
					int temp = intArr[i];
					intArr[i] = intArr[i + gap];
					intArr[i + gap] = temp;
				}
			}
		}
		while (gap > 1 || swapped);
	}

	public static void main(String[] args)
	{
		System.out.println("CombSort");

		int[] intArr =
		{ 4, 8, 0, 6, 1, 9, 7, 5, 3, 2 };

		System.out.println("before " + Arrays.toString(intArr));

		combSort(intArr);

		System.out.print("after  " + Arrays.toString(intArr));
	}
}
