package sort.string;

import java.util.Arrays;

public class SortString
{

	public static void main(String[] args)
	{
		System.out.println("String sort");

		String[] strings = { "m", "x", "z", "a", "c", "b", "l" };
		
		for(String s : strings)
		{
			System.out.print(s + ", ");
		}
		System.out.println();
		
		Arrays.sort(strings);
		
		for(String s : strings)
		{
			System.out.print(s + ", ");
		}
	}
}
