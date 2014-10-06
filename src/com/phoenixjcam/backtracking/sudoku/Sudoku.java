package com.phoenixjcam.backtracking.sudoku;
/**
 * The <code>Sudoku</code> class povides a static <code>main</code>
 * method allowing it to be called from the command line to print the
 * solution to a specified Sudoku problem.
 *
 * <p>The following is an example of a Sudoku :
 *
 * <p> Problem matrix 1:
 * <pre>
 * -----------------------
 * |   8   | 4   2 |   6   |
 * |   3 4 |       | 9 1   |
 * | 9 6   |       |   8 4 |
 *  -----------------------
 * |       | 2 1 6 |       |
 * |       |       |       |
 * |       | 3 5 7 |       |
 *  -----------------------
 * | 8 4   |       |   7 5 |
 * |   2 6 |       | 1 3   |
 * |   9   | 7   1 |   4   |
 *  -----------------------
 * </pre>
 * <p> Answer to matrix 1:
 * <pre>
 *  -----------------------
 * | 1 8 7 | 4 9 2 | 5 6 3 |
 * | 5 3 4 | 6 7 8 | 9 1 2 |
 * | 9 6 2 | 1 3 5 | 7 8 4 |
 *  -----------------------
 * | 4 5 8 | 2 1 6 | 3 9 7 |
 * | 2 7 3 | 8 4 9 | 6 5 1 |
 * | 6 1 9 | 3 5 7 | 4 2 8 |
 *  -----------------------
 * | 8 4 1 | 9 6 3 | 2 7 5 |
 * | 7 2 6 | 5 8 4 | 1 3 9 |
 * | 3 9 5 | 7 2 1 | 8 4 6 |
 *  -----------------------
 * </pre>
 *
 *
 * <p>See <a href="http://en.wikipedia.org/wiki/Sudoku">Wikipedia:
 * Sudoku</a> for more information on Sudoku.
 *
 * <p>The algorithm employed is similar to the standard backtracking
 * <a href="http://en.wikipedia.org/wiki/Eight_queens_puzzle">eight
 * queens algorithm</a>.
 *
 * @version 1.0
 * @author <a href="http://www.colloquial.com/carp">Bob Carpenter</a>
 * 
 * 
 */
public class Sudoku
{
	static boolean solve(int i, int j, int[][] cells)
	{
		if (i == 9)
		{
			i = 0;
			if (++j == 9)
				return true;
		}
		if (cells[i][j] != 0) // skip filled cells
			return solve(i + 1, j, cells);

		for (int val = 1; val <= 9; ++val)
		{
			if (legal(i, j, val, cells))
			{
				cells[i][j] = val;
				if (solve(i + 1, j, cells))
					return true;
			}
		}
		cells[i][j] = 0; // reset on backtrack
		return false;
	}

	static boolean legal(int i, int j, int val, int[][] cells)
	{
		for (int k = 0; k < 9; ++k)
			// row
			if (val == cells[k][j])
				return false;

		for (int k = 0; k < 9; ++k)
			// col
			if (val == cells[i][k])
				return false;

		int boxRowOffset = (i / 3) * 3;
		int boxColOffset = (j / 3) * 3;
		
		for (int k = 0; k < 3; ++k)
			// box
			for (int m = 0; m < 3; ++m)
				if (val == cells[boxRowOffset + k][boxColOffset + m])
					return false;

		return true; // no violations, so it's legal
	}

	static int[][] parseProblem(String[] args)
	{
		int[][] problem = new int[9][9]; // default 0 vals
		
		for (int n = 0; n < args.length; ++n)
		{
			int i = Integer.parseInt(args[n].substring(0, 1));
			int j = Integer.parseInt(args[n].substring(1, 2));
			int val = Integer.parseInt(args[n].substring(2, 3));
			
			problem[i][j] = val;
		}
		
		return problem;
	}

	static void writeMatrix(int[][] solution)
	{
		for (int i = 0; i < 9; ++i)
		{
			if (i % 3 == 0)
				System.out.println(" -----------------------");
			for (int j = 0; j < 9; ++j)
			{
				if (j % 3 == 0)
					System.out.print("| ");
				System.out.print(solution[i][j] == 0 ? " " : Integer.toString(solution[i][j]));

				System.out.print(' ');
			}
			System.out.println("|");
		}
		System.out.println(" -----------------------");
	}
	
	/**
	 * Print the specified Sudoku problem and its solution. The problem is encoded as specified in the class
	 * documentation above.
	 *
	 * @param args
	 *            The command-line arguments encoding the problem.
	 */
	public static void main(String[] args)
	{
		int[][] matrix = getMatrixFirstSample();
		//int[][] matrix = getMatrixSecondSample();
		
		if (solve(0, 0, matrix)) // solves in place
			writeMatrix(matrix);
		else
			System.out.println("NONE");
	}
	
	/**
	 * <p>
	 * Given problem:
	 * 
	 * <pre>
	 * int[][] matrix1 =
	 * {
	 * { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
	 * { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
	 * { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
	 * { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
	 * { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
	 * { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
	 * { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
	 * </pre>
	 * 
	 * <p>
	 * Answer:
	 * 
	 * 
	 * <pre>
	 *  -----------------------
	 * | 3 1 6 | 5 7 8 | 4 9 2 |
	 * | 5 2 9 | 1 3 4 | 7 6 8 |
	 * | 4 8 7 | 6 2 9 | 5 3 1 |
	 *  -----------------------
	 * | 2 6 3 | 4 1 5 | 9 8 7 |
	 * | 9 7 4 | 8 6 3 | 1 2 5 |
	 * | 8 5 1 | 7 9 2 | 6 4 3 |
	 *  -----------------------
	 * | 1 3 8 | 9 4 7 | 2 5 6 |
	 * | 6 9 2 | 3 5 1 | 8 7 4 |
	 * | 7 4 5 | 2 8 6 | 3 1 9 |
	 *  -----------------------
	 * </pre>
	 * 
	 * @return
	 */
	private static int[][] getMatrixFirstSample()
	{
		int[][] matrix1 =
		{
			{ 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
			{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
		};
		
		return matrix1;
	} 
	
	/**
	 * <p>
	 * Given problem:
	 * 
	 * <pre>
	 * int[][] matrix2 =
	 * {
		 * { 0, 4, 3, 7, 0, 0, 9, 0, 8 },
		 * { 0, 0, 5, 0, 3, 0, 0, 0, 0 },
		 * { 0, 1, 0, 0, 0, 0, 3, 0, 0 },
		 * { 6, 0, 0, 0, 2, 7, 0, 0, 0 },
		 * { 4, 0, 7, 0, 0, 0, 1, 0, 3 },
		 * { 0, 0, 0, 5, 4, 0, 0, 0, 9 },
		 * { 0, 0, 2, 0, 0, 0, 0, 3, 0 },
		 * { 0, 0, 0, 0, 5, 0, 4, 0, 0 },
		 * { 5, 0, 4, 0, 0, 1, 2, 6, 0 } 
	 * };
	 * </pre>
	 * 
	 * <p>
	 * Answer:
	 * 
	 * <pre>
	 *  -----------------------
	 * | 2 4 3 | 7 1 6 | 9 5 8 |
	 * | 9 8 5 | 2 3 4 | 7 1 6 |
	 * | 7 1 6 | 8 9 5 | 3 4 2 |
	 *  -----------------------
	 * | 6 3 9 | 1 2 7 | 5 8 4 |
	 * | 4 5 7 | 9 6 8 | 1 2 3 |
	 * | 8 2 1 | 5 4 3 | 6 7 9 |
	 *  -----------------------
	 * | 1 6 2 | 4 7 9 | 8 3 5 |
	 * | 3 7 8 | 6 5 2 | 4 9 1 |
	 * | 5 9 4 | 3 8 1 | 2 6 7 |
	 *  -----------------------
	 * </pre>
	 * 
	 * @return
	 */
	private static int[][] getMatrixSecondSample()
	{
		int[][] matrix2 =
		{
			{ 0, 4, 3, 7, 0, 0, 9, 0, 8 }, 
			{ 0, 0, 5, 0, 3, 0, 0, 0, 0 }, 
			{ 0, 1, 0, 0, 0, 0, 3, 0, 0 }, 
			{ 6, 0, 0, 0, 2, 7, 0, 0, 0 }, 
			{ 4, 0, 7, 0, 0, 0, 1, 0, 3 }, 
			{ 0, 0, 0, 5, 4, 0, 0, 0, 9 }, 
			{ 0, 0, 2, 0, 0, 0, 0, 3, 0 }, 
			{ 0, 0, 0, 0, 5, 0, 4, 0, 0 }, 
			{ 5, 0, 4, 0, 0, 1, 2, 6, 0 } 
		};
		
		return matrix2;
	}
}