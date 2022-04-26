import java.util.ArrayList;
import java.util.HashSet;

public class TestBoard {

	TileSet tileset;
	
	String[][] board;
	
	TestBoard (TileSet ts, String[][] init)
	{
		tileset = ts;
		
		board = init;
	}
	
	String generable(int x, int y)
	{	
		if (board[y][x] != null)
			return null;
		
		String[] ngbs = new String[8];
		
		if (x+1 != board[0].length && board[y][x+1] != null)
			ngbs[0] = tileset.quickset.get(board[y][x+1]).edges[6];
		if (x+1 != board[0].length && y-1 != -1 && board[y-1][x+1] != null)
			ngbs[1] = tileset.quickset.get(board[y-1][x+1]).edges[5];
		if (y-1 != -1 && board[y-1][x] != null)
			ngbs[2] = tileset.quickset.get(board[y-1][x]).edges[4];
		if (x-1 != -1 && y-1 != -1 && board[y-1][x-1] != null)
			ngbs[3] = tileset.quickset.get(board[y-1][x-1]).edges[3];
		if (x-1 != -1 && board[y][x-1] != null)
			ngbs[4] = tileset.quickset.get(board[y][x-1]).edges[2];
		if (x-1 != -1 && y+1 != board.length && board[y+1][x-1] != null)
			ngbs[5] = tileset.quickset.get(board[y+1][x-1]).edges[1];
		if (y+1 != board.length  && board[y+1][x] != null)
			ngbs[6] = tileset.quickset.get(board[y+1][x]).edges[0];
		if (y+1 != board.length && x+1 != board[0].length && board[y+1][x+1] != null)
		{
			ngbs[7] = tileset.quickset.get(board[y+1][x+1]).edges[7];
		}
		
		int k;
		for (k = 0; k < 8 && ngbs[k] == null; k++);
		
		if (k == 8)
			return null;
		
		HashSet<String> cands = (HashSet<String>)tileset.edgebodies[k].get(ngbs[k]).clone();
			
		for (int p = k+1; p < 8; p++)
			if (ngbs[p] != null)
			{
				cands.retainAll(tileset.edgebodies[p].get(ngbs[p]));
			}


		if (x==2 && y==4 && cands.size()==1)
			System.out.println(cands.iterator().next());
		
		if (cands.size() != 1)
			return null;
		
		return cands.iterator().next();
	}
	
	boolean iterate()
	{
		ArrayList<Integer> xs = new ArrayList<Integer>();
		ArrayList<Integer> ys = new ArrayList<Integer>();
		ArrayList<String> vals = new ArrayList<String>();
		
		boolean b = false;
		
		for (int x = 0; x < board[0].length; x++)
			for (int y = 0; y < board.length; y++)
			{
				String s = generable(x, y);
				if (s != null)
				{
					xs.add(x);
					ys.add(y);
					vals.add(s);
					b = true;
				}
			}
		
		for (int k = 0; k < xs.size(); k++)
		{
			board[ys.get(k)][xs.get(k)] = vals.get(k);
		}
		
		return b;
	}
	
	static char getChar (String s)
	{
		if (s == null)
			return ' ';
		else if (s.charAt(0) == 'b')
			return '#';
		else
			return '_';
	}
	
	static char getChar2 (String s)
	{
		if (s == null)
			return ' ';
		else if (s.charAt(0) == 'b')
			return '█';
		else if (s.charAt(0) == 's')
			return 'S';
		else 
			return '-';
	}
	
	public void print()
	{
		for (int y = 0; y < board.length; y++)
		{
			for (int x = 0; x < board[0].length; x++)
			{
				System.out.print(getChar(board[y][x]));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void print2()
	{
		for (int y = 0; y < board.length; y++)
		{
			for (int x = 0; x < board[0].length; x++)
			{
				System.out.print(getChar2(board[y][x]));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		TileSet ts = new TileSet ("//Users/alogan/Desktop/TYPE2/rt.tds");
		
		String[][] init = new String[51][51];
		
		init[25][25] = "seed";
		
		TestBoard b = new TestBoard(ts, init);
		
		for (int k = 0; k < 40; k++)
		{
			b.print2();
			System.out.println("------------------------------------------------------------------------");
			b.iterate();
		}
		
		
	}
	
}
