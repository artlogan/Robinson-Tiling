import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashSet;

public class aTAMTileSet {

	HashSet<ATAMTile> tileset;
	
	aTAMTileSet()
	{
		tileset = new HashSet<ATAMTile>();
	}
	
	boolean addTile (ATAMTile t)
	{
		return tileset.add(t);
	}
	
	void writeTDS (String address)
	{
		try {
			FileWriter fw = new FileWriter (new File("//Users/alogan/Desktop/TESTING/frt.tds"));
			
			for (ATAMTile t : tileset)
				fw.write(t.toString());
			
			fw.close();
		} catch (IOException e) {}
	}
}
