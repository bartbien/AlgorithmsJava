package sort.string;

public class SwapString
{
	public static void main(String[] args)
	{
		String strArr[] =
		{ "f", "c", "a", "g", "d" };
		boolean swap = true;
		int j = 0;
		while (swap)
		{
			swap = false;
			j++;
			for (int i = 0; i < strArr.length - j; i++)
			{
				if (strArr[i].compareTo(strArr[i + 1]) > 0)
				{
					String tmp = strArr[i];
					strArr[i] = strArr[i + 1];
					strArr[i + 1] = tmp;
					swap = true;
				}

			}

		}
		
		for(String s : strArr)
			System.out.print(s + ", ");
	}
}
