package com.phoenixjcam.sorting;

import java.util.Random;

public class BubbleSort
{
	public static void main(String[] args)
	{
		Random randomizer = new Random();
		int[] data = new int[100];

		for (int i = 1; i < data.length; ++i)
		{
			data[i] = randomizer.nextInt(100);
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
}
