package search.binary;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Binary search or half-interval search algorithm. <br>
 * Divide and conquer - often binary search is mention as Divide and conquer in algorithms resources. <br>
 * Finds the position of a specified input value (the search "key") within an array sorted by key value. <br>
 * <a
 * href="http://en.wikipedia.org/wiki/Binary_search_algorithm">http://en.wikipedia.org/wiki/Binary_search_algorithm</a> <br>
 * <br>
 * <br>
 * Worst case performance O(log2 n) - for 1 000 000 elements it'll be ~20 steps<br>
 * Best case performance O(1)<br>
 * More about Time complexity:<br>
 * <br>
 * <a href="http://en.wikipedia.org/wiki/Big_O_notation#Orders_of_common_functions">http://en.wikipedia.org/wiki/
 * Big_O_notation#Orders_of_common_functions</a>
 * 
 * @author Bart88
 *
 */
public class BinarySearch
{
	/**
	 * Searches for the integer key in the sorted array a[].
	 * 
	 * @param key
	 *            the search key
	 * @param sortedArray
	 *            the array of integers, must be sorted in ascending order
	 * @return index of key in sortedArray[] if present; -1 if not present
	 */
	public static int rank(int key, int[] sortedArray)
	{
		int min = 0;
		int max = sortedArray.length - 1;

		while (min <= max)
		{
			// Key is in a[min...max] or not present.
			int subIndex = min + (max - min) / 2;

			if (key < sortedArray[subIndex])
			{
				max = subIndex - 1;
			}
			else if (key > sortedArray[subIndex])
			{
				min = subIndex + 1;
			}
			else
			{
				System.out.println("index of key in sortedArray[]: " + subIndex);
				return subIndex;
			}
		}

		return -1;
	}

	public static void main(String[] args)
	{
		int[] unsortedArray =
		{ 2, 1, 9, 4, 5, 7, 6, 8, 3 };

		// sort the array
		Arrays.sort(unsortedArray);
		int[] sortedArray = unsortedArray;
		
		Scanner in = new Scanner(System.in);

		int key;

		System.out.println("Start typing ");

		do
		{
			key = in.nextInt();

			System.out.println("typed: " + key);

			if (rank(key, sortedArray) == -1)
				System.out.println(key);
		}
		while (key != -1);

		System.out.println("Ended with value: " + key);

	}
}