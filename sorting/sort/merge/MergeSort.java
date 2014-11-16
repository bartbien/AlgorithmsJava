package sort.merge;

import java.util.Arrays;

public class MergeSort
{

	private static int[] intArr =
	{ 4, 8, 0, 6, 1, 9, 7, 5, 3, 2 };

	public static void sort()
	{
		int[] tempArray = new int[intArr.length];
		mergeSort(tempArray, 0, intArr.length - 1);
	}

	public static void mergeSort(int[] tempArray, int lowerIndex, int upperIndex)
	{
		if (lowerIndex == upperIndex)
		{
			return;
		}
		else
		{
			int mid = (lowerIndex + upperIndex) / 2;
			mergeSort(tempArray, lowerIndex, mid);
			mergeSort(tempArray, mid + 1, upperIndex);
			merge(tempArray, lowerIndex, mid + 1, upperIndex);
		}
	}

	public static void merge(int[] tempArray, int lowerIndexCursor, int higerIndex, int upperIndex)
	{
		int tempIndex = 0;
		int lowerIndex = lowerIndexCursor;
		int midIndex = higerIndex - 1;
		int totalItems = upperIndex - lowerIndex + 1;
		while (lowerIndex <= midIndex && higerIndex <= upperIndex)
		{
			if (intArr[lowerIndex] < intArr[higerIndex])
			{
				tempArray[tempIndex++] = intArr[lowerIndex++];
			}
			else
			{
				tempArray[tempIndex++] = intArr[higerIndex++];
			}
		}

		while (lowerIndex <= midIndex)
		{
			tempArray[tempIndex++] = intArr[lowerIndex++];
		}

		while (higerIndex <= upperIndex)
		{
			tempArray[tempIndex++] = intArr[higerIndex++];
		}

		for (int i = 0; i < totalItems; i++)
		{
			intArr[lowerIndexCursor + i] = tempArray[i];
		}
	}

	public static void main(String[] args)
	{
		System.out.println("MergeSort");

		System.out.println("before " + Arrays.toString(intArr));

		sort();
		
		System.out.print("after  " + Arrays.toString(intArr));
	}
}