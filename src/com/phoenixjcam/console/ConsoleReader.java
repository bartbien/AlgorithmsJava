package com.phoenixjcam.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReader
{
	private static void bufferReader()
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter user name : ");
		String username = null;
		try
		{
			username = reader.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("You entered : " + username);
	}

	private static void scanner()
	{
		// ===== In Java 5, Java.util,Scanner is used for this purpose.
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter user name : ");
		String username = in.nextLine();
		System.out.println("You entered : " + username);

		// ====== Java 6
		// Console console = System.console();
		// but in eclipse case not work well
	}

	private static void scannerLoop()
	{
		Scanner in = new Scanner(System.in);
		
		String key;
		
		do
		{
			key = in.nextLine();
			System.out.println("typed: " + key);
		}
		while (key != "q");
		
	}

	public static void main(String[] args)
	{
		scannerLoop();
	}

}
