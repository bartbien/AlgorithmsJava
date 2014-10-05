package com.phoenixjcam.sorting.distribution;

import java.util.Arrays;

/** Class RadixSort **/

public class RadixSort
{
	/** Radix Sort function **/

	public static void sort(int[] a)
	{

		int i, m = a[0], exp = 1, n = a.length;

		int[] b = new int[10];

		for (i = 1; i < n; i++)

			if (a[i] > m)

				m = a[i];

		while (m / exp > 0)
		{
			int[] bucket = new int[10];

			for (i = 0; i < n; i++)
				bucket[(a[i] / exp) % 10]++;

			for (i = 1; i < 10; i++)
				bucket[i] += bucket[i - 1];

			for (i = n - 1; i >= 0; i--)
				b[--bucket[(a[i] / exp) % 10]] = a[i];

			for (i = 0; i < n; i++)
				a[i] = b[i];

			exp *= 10;
		}
	}

	/** Main method **/
	public static void main(String[] args)
	{

		System.out.println("RadixSort");

		int[] intArr =
		{ 4, 8, 0, 6, 1, 9, 7, 5, 3, 2 };

		System.out.println("before " + Arrays.toString(intArr));

		sort(intArr);

		System.out.print("after  " + Arrays.toString(intArr));

	}
}