import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
public class OCT {
	
	static void writeTile(String name, String[] sidelabels, FileWriter fw) throws IOException
	{
		if (!(name.length() == 1))
			fw.write("TILENAME "+name+'\n');
		else
		{
			String s = name;
			for (String t : sidelabels)
				s += t;
			fw.write("TILENAME "+s+'\n');
		}
		fw.write("NORTHLABEL " + sidelabels[2]+'\n');
		fw.write("NORTHEASTLABEL " + sidelabels[1]+'\n');
		fw.write("EASTLABEL " + sidelabels[0]+'\n');
		fw.write("SOUTHEASTLABEL " + sidelabels[7]+'\n');
		fw.write("SOUTHLABEL " + sidelabels[6]+'\n');
		fw.write("SOUTHWESTLABEL " + sidelabels[5]+'\n');
		fw.write("WESTLABEL " + sidelabels[4]+'\n');
		fw.write("NORTHWESTLABEL " + sidelabels[3]+'\n');
		fw.write('\n');
	}

	public static void main(String args[]) throws IOException
	{
		FileWriter fw = new FileWriter(new File ("/Users/alogan/Desktop/TYPE2/rt.tds"));
		
		//seed
		writeTile("seed", new String[] {"xE", "B", "x", "B", "x", "B", "x", "B"}, fw);
		
		//east corners
		writeTile("bec30", new String[] {"x", "B", "B", "0NE", "xE", "3SE", "B", "B"}, fw);
		writeTile("bec01", new String[] {"x", "B", "B", "1NE", "x", "0SE", "B", "B"}, fw);
		writeTile("bec12", new String[] {"x", "B", "B", "2NE", "x", "1SE", "B", "B"}, fw);
		writeTile("bec23", new String[] {"xE", "B", "B", "3NE", "x", "2SE", "B", "B"}, fw);
		
		//north corners
		writeTile("bnc30", new String[] {"B", "B", "x", "B", "B", "0NW", "xN", "3NE"}, fw);
		writeTile("bnc01", new String[] {"B", "B", "x", "B", "B", "1NW", "x", "0NE"}, fw);
		writeTile("bnc12", new String[] {"B", "B", "x", "B", "B", "2NW", "x", "1NE"}, fw);
		writeTile("bnc23", new String[] {"B", "B", "xN", "B", "B", "3NW", "x", "2NE"}, fw);
		
		//west corners
		writeTile("bwc30", new String[] {"xW", "3NW", "B", "B", "x", "B", "B", "0SW"}, fw);
		writeTile("bwc01", new String[] {"x", "0NW", "B", "B", "x", "B", "B", "1SW"}, fw);
		writeTile("bwc12", new String[] {"x", "1NW", "B", "B", "x", "B", "B", "2SW"}, fw);
		writeTile("bwc23", new String[] {"x", "2NW", "B", "B", "xW", "B", "B", "3SW"}, fw);

		//south corners
		writeTile("bsc30", new String[] {"B", "0SE", "xS", "3SW", "B", "B", "x", "B"}, fw);
		writeTile("bsc01", new String[] {"B", "1SE", "x", "0SW", "B", "B", "x", "B"}, fw);
		writeTile("bsc12", new String[] {"B", "2SE", "x", "1SW", "B", "B", "x", "B"}, fw);
		writeTile("bsc23", new String[] {"B", "3SE", "x", "2SW", "B", "B", "xS", "B"}, fw);
		
		//ne side
		writeTile("b", new String[] {"B", "B", "B", "0NE", "W", "W", "B", "0NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "0NE", "W", "B", "B", "0NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "0NE", "B", "W", "W", "0NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "0NE", "B", "B", "W", "0NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "0NE", "B", "W", "B", "0NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "0NE", "B", "B", "B", "0NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "0NE", "W", "W", "W", "0NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "0NE", "W", "B", "W", "0NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "1NE", "W", "W", "B", "1NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "1NE", "W", "B", "B", "1NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "1NE", "B", "W", "W", "1NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "1NE", "B", "B", "W", "1NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "1NE", "B", "W", "B", "1NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "1NE", "B", "B", "B", "1NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "1NE", "W", "W", "W", "1NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "1NE", "W", "B", "W", "1NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "2NE", "W", "W", "B", "2NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "2NE", "W", "B", "B", "2NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "2NE", "B", "W", "W", "2NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "2NE", "B", "B", "W", "2NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "2NE", "B", "W", "B", "2NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "2NE", "B", "B", "B", "2NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "2NE", "W", "W", "W", "2NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "2NE", "W", "B", "W", "2NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "3NE", "W", "W", "B", "3NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "3NE", "W", "B", "B", "3NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "3NE", "B", "W", "W", "3NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "3NE", "B", "B", "W", "3NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "3NE", "B", "W", "B", "3NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "3NE", "B", "B", "B", "3NE"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "3NE", "W", "W", "W", "3NE"}, fw);
		writeTile("b", new String[] {"B", "B", "B", "3NE", "W", "B", "W", "3NE"}, fw);
		
		//nw side
		writeTile("b", new String[] {"W", "0NW", "B", "B", "B", "0NW", "B", "W"}, fw);
		writeTile("b", new String[] {"W", "0NW", "B", "B", "B", "0NW", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "0NW", "B", "B", "B", "0NW", "W", "W"}, fw);
		writeTile("b", new String[] {"B", "0NW", "B", "B", "B", "0NW", "W", "B"}, fw);
		writeTile("w", new String[] {"B", "0NW", "W", "W", "W", "0NW", "B", "W"}, fw);
		writeTile("w", new String[] {"B", "0NW", "W", "W", "W", "0NW", "B", "B"}, fw);
		writeTile("w", new String[] {"W", "0NW", "W", "W", "W", "0NW", "W", "W"}, fw);
		writeTile("b", new String[] {"W", "0NW", "B", "B", "B", "0NW", "W", "B"}, fw);
		writeTile("b", new String[] {"W", "1NW", "B", "B", "B", "1NW", "B", "W"}, fw);
		writeTile("b", new String[] {"W", "1NW", "B", "B", "B", "1NW", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "1NW", "B", "B", "B", "1NW", "W", "W"}, fw);
		writeTile("b", new String[] {"B", "1NW", "B", "B", "B", "1NW", "W", "B"}, fw);
		writeTile("w", new String[] {"B", "1NW", "W", "W", "W", "1NW", "B", "W"}, fw);
		writeTile("w", new String[] {"B", "1NW", "W", "W", "W", "1NW", "B", "B"}, fw);
		writeTile("w", new String[] {"W", "1NW", "W", "W", "W", "1NW", "W", "W"}, fw);
		writeTile("b", new String[] {"W", "1NW", "B", "B", "B", "1NW", "W", "B"}, fw);
		writeTile("b", new String[] {"W", "2NW", "B", "B", "B", "2NW", "B", "W"}, fw);
		writeTile("b", new String[] {"W", "2NW", "B", "B", "B", "2NW", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "2NW", "B", "B", "B", "2NW", "W", "W"}, fw);
		writeTile("b", new String[] {"B", "2NW", "B", "B", "B", "2NW", "W", "B"}, fw);
		writeTile("w", new String[] {"B", "2NW", "W", "W", "W", "2NW", "B", "W"}, fw);
		writeTile("w", new String[] {"B", "2NW", "W", "W", "W", "2NW", "B", "B"}, fw);
		writeTile("w", new String[] {"W", "2NW", "W", "W", "W", "2NW", "W", "W"}, fw);
		writeTile("b", new String[] {"W", "2NW", "B", "B", "B", "2NW", "W", "B"}, fw);
		writeTile("b", new String[] {"W", "3NW", "B", "B", "B", "3NW", "B", "W"}, fw);
		writeTile("b", new String[] {"W", "3NW", "B", "B", "B", "3NW", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "3NW", "B", "B", "B", "3NW", "W", "W"}, fw);
		writeTile("b", new String[] {"B", "3NW", "B", "B", "B", "3NW", "W", "B"}, fw);
		writeTile("w", new String[] {"B", "3NW", "W", "W", "W", "3NW", "B", "W"}, fw);
		writeTile("w", new String[] {"B", "3NW", "W", "W", "W", "3NW", "B", "B"}, fw);
		writeTile("w", new String[] {"W", "3NW", "W", "W", "W", "3NW", "W", "W"}, fw);
		writeTile("b", new String[] {"W", "3NW", "B", "B", "B", "3NW", "W", "B"}, fw);
		
		//sw side
		writeTile("b", new String[] {"W", "W", "B", "0SW", "B", "B", "B", "0SW"}, fw);
		writeTile("b", new String[] {"W", "B", "B", "0SW", "B", "B", "B", "0SW"}, fw);
		writeTile("b", new String[] {"B", "W", "W", "0SW", "B", "B", "B", "0SW"}, fw);
		writeTile("b", new String[] {"B", "B", "W", "0SW", "B", "B", "B", "0SW"}, fw);
		writeTile("w", new String[] {"B", "W", "B", "0SW", "W", "W", "W", "0SW"}, fw);
		writeTile("w", new String[] {"B", "B", "B", "0SW", "W", "W", "W", "0SW"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "0SW", "W", "W", "W", "0SW"}, fw);
		writeTile("b", new String[] {"W", "B", "W", "0SW", "B", "B", "B", "0SW"}, fw);
		writeTile("b", new String[] {"W", "W", "B", "1SW", "B", "B", "B", "1SW"}, fw);
		writeTile("b", new String[] {"W", "B", "B", "1SW", "B", "B", "B", "1SW"}, fw);
		writeTile("b", new String[] {"B", "W", "W", "1SW", "B", "B", "B", "1SW"}, fw);
		writeTile("b", new String[] {"B", "B", "W", "1SW", "B", "B", "B", "1SW"}, fw);
		writeTile("w", new String[] {"B", "W", "B", "1SW", "W", "W", "W", "1SW"}, fw);
		writeTile("w", new String[] {"B", "B", "B", "1SW", "W", "W", "W", "1SW"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "1SW", "W", "W", "W", "1SW"}, fw);
		writeTile("b", new String[] {"W", "B", "W", "1SW", "B", "B", "B", "1SW"}, fw);
		writeTile("b", new String[] {"W", "W", "B", "2SW", "B", "B", "B", "2SW"}, fw);
		writeTile("b", new String[] {"W", "B", "B", "2SW", "B", "B", "B", "2SW"}, fw);
		writeTile("b", new String[] {"B", "W", "W", "2SW", "B", "B", "B", "2SW"}, fw);
		writeTile("b", new String[] {"B", "B", "W", "2SW", "B", "B", "B", "2SW"}, fw);
		writeTile("w", new String[] {"B", "W", "B", "2SW", "W", "W", "W", "2SW"}, fw);
		writeTile("w", new String[] {"B", "B", "B", "2SW", "W", "W", "W", "2SW"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "2SW", "W", "W", "W", "2SW"}, fw);
		writeTile("b", new String[] {"W", "B", "W", "2SW", "B", "B", "B", "2SW"}, fw);
		writeTile("b", new String[] {"W", "W", "B", "3SW", "B", "B", "B", "3SW"}, fw);
		writeTile("b", new String[] {"W", "B", "B", "3SW", "B", "B", "B", "3SW"}, fw);
		writeTile("b", new String[] {"B", "W", "W", "3SW", "B", "B", "B", "3SW"}, fw);
		writeTile("b", new String[] {"B", "B", "W", "3SW", "B", "B", "B", "3SW"}, fw);
		writeTile("w", new String[] {"B", "W", "B", "3SW", "W", "W", "W", "3SW"}, fw);
		writeTile("w", new String[] {"B", "B", "B", "3SW", "W", "W", "W", "3SW"}, fw);
		writeTile("w", new String[] {"W", "W", "W", "3SW", "W", "W", "W", "3SW"}, fw);
		writeTile("b", new String[] {"W", "B", "W", "3SW", "B", "B", "B", "3SW"}, fw);
		
		//se side
		writeTile("b", new String[] {"B", "0SE", "W", "W", "B", "0SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "0SE", "W", "B", "B", "0SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "0SE", "B", "W", "W", "0SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "0SE", "B", "B", "W", "0SE", "B", "B"}, fw);
		writeTile("w", new String[] {"W", "0SE", "B", "W", "B", "0SE", "W", "W"}, fw);
		writeTile("w", new String[] {"W", "0SE", "B", "B", "B", "0SE", "W", "W"}, fw);
		writeTile("w", new String[] {"W", "0SE", "W", "W", "W", "0SE", "W", "W"}, fw);
		writeTile("b", new String[] {"B", "0SE", "W", "B", "W", "0SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "1SE", "W", "W", "B", "1SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "1SE", "W", "B", "B", "1SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "1SE", "B", "W", "W", "1SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "1SE", "B", "B", "W", "1SE", "B", "B"}, fw);
		writeTile("w", new String[] {"W", "1SE", "B", "W", "B", "1SE", "W", "W"}, fw);
		writeTile("w", new String[] {"W", "1SE", "B", "B", "B", "1SE", "W", "W"}, fw);
		writeTile("w", new String[] {"W", "1SE", "W", "W", "W", "1SE", "W", "W"}, fw);
		writeTile("b", new String[] {"B", "1SE", "W", "B", "W", "1SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "2SE", "W", "W", "B", "2SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "2SE", "W", "B", "B", "2SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "2SE", "B", "W", "W", "2SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "2SE", "B", "B", "W", "2SE", "B", "B"}, fw);
		writeTile("w", new String[] {"W", "2SE", "B", "W", "B", "2SE", "W", "W"}, fw);
		writeTile("w", new String[] {"W", "2SE", "B", "B", "B", "2SE", "W", "W"}, fw);
		writeTile("w", new String[] {"W", "2SE", "W", "W", "W", "2SE", "W", "W"}, fw);
		writeTile("b", new String[] {"B", "2SE", "W", "B", "W", "2SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "3SE", "W", "W", "B", "3SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "3SE", "W", "B", "B", "3SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "3SE", "B", "W", "W", "3SE", "B", "B"}, fw);
		writeTile("b", new String[] {"B", "3SE", "B", "B", "W", "3SE", "B", "B"}, fw);
		writeTile("w", new String[] {"W", "3SE", "B", "W", "B", "3SE", "W", "W"}, fw);
		writeTile("w", new String[] {"W", "3SE", "B", "B", "B", "3SE", "W", "W"}, fw);
		writeTile("w", new String[] {"W", "3SE", "W", "W", "W", "3SE", "W", "W"}, fw);
		writeTile("b", new String[] {"B", "3SE", "W", "B", "W", "3SE", "B", "B"}, fw);
		
		fw.close();
	}
	
}
