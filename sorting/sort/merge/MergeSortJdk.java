package sort.merge;

import java.lang.reflect.Array;

/**
 * 
 * java.utils.Arrays
 * 
 * 
 * @author BartBien
 *
 */
public class MergeSortJdk
{
	private static final int INSERTIONSORT_THRESHOLD = 7;

	private static void legacyMergeSort(Object[] a, int fromIndex, int toIndex)
	{
		Object[] aux = copyOfRange(a, fromIndex, toIndex);
		mergeSort(aux, a, fromIndex, toIndex, -fromIndex);
	}

	public static <T, U> T[] copyOfRange(U[] original, int from, int to, Class<? extends T[]> newType)
	{
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		@SuppressWarnings("unchecked")
		T[] copy = ((Object) newType == (Object) Object[].class) ? (T[]) new Object[newLength] : (T[]) Array.newInstance(newType.getComponentType(), newLength);
		System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
		return copy;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] copyOfRange(T[] original, int from, int to)
	{
		return copyOfRange(original, from, to, (Class<? extends T[]>) original.getClass());
	}

	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	private static void mergeSort(Object[] src, Object[] dest, int low, int high, int off)
	{
		int length = high - low;

		// Insertion sort on smallest arrays
		if (length < INSERTIONSORT_THRESHOLD)
		{
			for (int i = low; i < high; i++)
				for (int j = i; j > low && ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--)
					swap(dest, j, j - 1);
			return;
		}

		// Recursively sort halves of dest into src
		int destLow = low;
		int destHigh = high;
		low += off;
		high += off;
		int mid = (low + high) >>> 1;
		mergeSort(dest, src, low, mid, -off);
		mergeSort(dest, src, mid, high, -off);

		// If list is already sorted, just copy from src to dest. This is an
		// optimization that results in faster sorts for nearly ordered lists.
		if (((Comparable) src[mid - 1]).compareTo(src[mid]) <= 0)
		{
			System.arraycopy(src, low, dest, destLow, length);
			return;
		}

		// Merge sorted halves (now in src) into dest
		for (int i = destLow, p = low, q = mid; i < destHigh; i++)
		{
			if (q >= high || p < mid && ((Comparable) src[p]).compareTo(src[q]) <= 0)
				dest[i] = src[p++];
			else
				dest[i] = src[q++];
		}
	}

	/**
	 * Swaps x[a] with x[b].
	 */
	private static void swap(Object[] x, int a, int b)
	{
		Object t = x[a];
		x[a] = x[b];
		x[b] = t;
	}

	public static void main(String[] args)
	{

	}
}
