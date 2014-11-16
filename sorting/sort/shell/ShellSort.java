package sort.shell;

import java.util.Arrays;

public class ShellSort
{
	public static void shellSort(int[] a)
	{
		int increment = a.length / 2;
		while (increment > 0)
		{
			for (int i = increment; i < a.length; i++)
			{
				int j = i;
				int temp = a[i];
				while (j >= increment && a[j - increment] > temp)
				{
					a[j] = a[j - increment];
					j = j - increment;
				}
				a[j] = temp;
			}
			if (increment == 2)
			{
				increment = 1;
			}
			else
			{
				increment *= (5.0 / 11);
			}
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("ShellSort");
		
		int[] intArr =
		{ 4, 8, 0, 6, 1, 9, 7, 5, 3, 2 };

		System.out.println("before " + Arrays.toString(intArr));

		shellSort(intArr);

		System.out.print("after  " + Arrays.toString(intArr));
	}
}
