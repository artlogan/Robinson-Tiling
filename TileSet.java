import java.util.LinkedList;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class TileSet {
	
	LinkedList<OctTile> tileset;
	HashMap<String, OctTile> quickset;
	HashSet<String>[] edgesets;
	HashMap<String, HashSet<String>>[] edgebodies;

	TileSet(String tdsfile)
	{
		tileset = new LinkedList<OctTile>();
		quickset = new HashMap<String, OctTile>();
		edgesets = new HashSet[8]; //N NE E ...
		edgebodies = new HashMap[8]; //E NE N ...
		
		for (int k = 0; k < 8; k++)
		{
			edgesets[k] = new HashSet<String>();
			edgebodies[k] = new HashMap<String, HashSet<String>>();
		}
		
		try {
			
			Scanner scan = new Scanner(new File(tdsfile));
			try
			{
				for (String s = scan.next(); ; s = scan.next())
				{

					while (!s.contentEquals("TILENAME"))
						s = scan.next();

					OctTile t = new OctTile(scan.next());
					
					while (!s.contentEquals("NORTHLABEL"))
						s = scan.next();
					
					t.edges[0] = scan.next();
					
					while (!s.contentEquals("NORTHEASTLABEL"))
						s = scan.next();
					
					t.edges[1] = scan.next();
					
					while (!s.contentEquals("EASTLABEL"))
						s = scan.next();
					
					t.edges[2] = scan.next();
					
					while (!s.contentEquals("SOUTHEASTLABEL"))
						s = scan.next();
					
					t.edges[3] =  scan.next();
					
					while (!s.contentEquals("SOUTHLABEL"))
						s = scan.next();
					
					t.edges[4] = scan.next();
					
					while (!s.contentEquals("SOUTHWESTLABEL"))
						s = scan.next();
					
					t.edges[5] = scan.next();
					
					while (!s.contentEquals("WESTLABEL"))
						s = scan.next();
					
					t.edges[6] = scan.next();
					
					while (!s.contentEquals("NORTHWESTLABEL"))
						s = scan.next();
					
					t.edges[7] = scan.next();
					
					tileset.add(t);
					
					for (int k = 0; k<8; k++)
						edgesets[k].add(t.edges[k]);
					
					if (!edgebodies[0].containsKey(t.edges[2]))
						edgebodies[0].put(t.edges[2], new HashSet<String>());
					edgebodies[0].get(t.edges[2]).add(t.name);
					
					if (!edgebodies[1].containsKey(t.edges[1]))
						edgebodies[1].put(t.edges[1], new HashSet<String>());
					edgebodies[1].get(t.edges[1]).add(t.name);
					
					if (!edgebodies[2].containsKey(t.edges[0]))
						edgebodies[2].put(t.edges[0], new HashSet<String>());
					edgebodies[2].get(t.edges[0]).add(t.name);
					
					if (!edgebodies[3].containsKey(t.edges[7]))
						edgebodies[3].put(t.edges[7], new HashSet<String>());
					edgebodies[3].get(t.edges[7]).add(t.name);
					
					if (!edgebodies[4].containsKey(t.edges[6]))
						edgebodies[4].put(t.edges[6], new HashSet<String>());
					edgebodies[4].get(t.edges[6]).add(t.name);
					
					if (!edgebodies[5].containsKey(t.edges[5]))
						edgebodies[5].put(t.edges[5], new HashSet<String>());
					edgebodies[5].get(t.edges[5]).add(t.name);
					
					if (!edgebodies[6].containsKey(t.edges[4]))
						edgebodies[6].put(t.edges[4], new HashSet<String>());
					edgebodies[6].get(t.edges[4]).add(t.name);
					
					if (!edgebodies[7].containsKey(t.edges[3]))
						edgebodies[7].put(t.edges[3], new HashSet<String>());
					edgebodies[7].get(t.edges[3]).add(t.name);
						
					quickset.put(t.name, t);
				}
			} catch (NoSuchElementException e) {}
			
			
		} catch (FileNotFoundException f) {System.out.println("NF");}
	}

	OctTile getTile(String name)
	{
		return quickset.get(name);
	}
	
	//{W, E}
	LinkedList<OctTile>[] equalWE (String edge)
	{
		LinkedList<OctTile> W = new LinkedList<OctTile>();
		LinkedList<OctTile> E = new LinkedList<OctTile>();
		
		for (OctTile t : tileset)
		{
			if (t.edges[2].contentEquals(edge))
				W.add(t);
			if (t.edges[6].contentEquals(edge))
				E.add(t);
		}
		
		return new LinkedList[] {W, E};
	}

	//{N, S}
	LinkedList<OctTile>[] equalNS (String edge)
	{
		LinkedList<OctTile> N = new LinkedList<OctTile>();
		LinkedList<OctTile> S = new LinkedList<OctTile>();
		
		for (OctTile t : tileset)
		{
			if (t.edges[4].contentEquals(edge))
				N.add(t);
			if (t.edges[0].contentEquals(edge))
				S.add(t);
		}
		
		return new LinkedList[] {N, S};
	}
	
	//returns {n, e, s, w}
	HashSet[] junctions()
	{
		HashSet<String> horedg = new HashSet<String>();
		HashSet<String> vertedg = new HashSet<String>();
		
		HashSet<String> n = new HashSet<String>();
		HashSet<String> e = new HashSet<String>();
		HashSet<String> s = new HashSet<String>();
		HashSet<String> w = new HashSet<String>();
		
		for (OctTile t : tileset)
		{
			if(!horedg.contains(t.edges[4]))
			{
				horedg.add(t.edges[4]);
				
				LinkedList<OctTile>[] j = equalNS(t.edges[4]);
				
				for (OctTile a : j[0])
					for (OctTile b : j[1])
					{
						w.add(a.edges[3] + ' ' + b.edges[1]);
						e.add(a.edges[5] + ' ' + b.edges[7]);
					}
				
			}
			
			if(!vertedg.contains(t.edges[2]))
			{
				vertedg.add(t.edges[2]);
				
				LinkedList<OctTile>[] k = equalWE(t.edges[2]);
				
				for (OctTile c : k[0])
					for (OctTile d : k[1])
					{
						s.add(c.edges[1] + ' ' + d.edges[7]);
						n.add(c.edges[3] + ' ' + d.edges[5]);
					}
			}
		}
		
		return new HashSet[] {n, e, s, w};
	}
	
	HashSet<String> unique2hoods(int i)
	{
		HashMap<String, String> hoods = new HashMap<String, String>();
		HashMap<String, LinkedList<String>> growthhoods = new HashMap<String, LinkedList<String>>();
		
		for (OctTile t : tileset)
		{
			String s = t.edges[i] + " " + t.edges[(i+1)%8];
			if (hoods.containsKey(s))
				hoods.put(s, "");
			else
				hoods.put(s, t.name);
			
			//assumes all growth tiles are generated using only 2 neighbors
			if (t.name.indexOf("grow") != -1)
			{
				if (!growthhoods.containsKey(s))
					growthhoods.put(s, new LinkedList<String>());
				growthhoods.get(s).add(t.name);
			}
			else if (growthhoods.containsKey(s))
				growthhoods.remove(s);
				
			
		}
		
		HashSet<String> ret = new HashSet<String>();
		
		for (String s : hoods.keySet())
		{
			if (hoods.get(s).length() != 0)
				ret.add(hoods.get(s) + " " + s);
		}
		
		for (String s : growthhoods.keySet())
		{
			for (String g : growthhoods.get(s))
				ret.add(g + ' ' + s);
		}
		
		return ret;
	}
	
	HashSet<String> unique3hoods(int i)
	{
		HashSet<String> a = unique2hoods(i);
		HashSet<String> b = unique2hoods((i+1)%8);
		
		HashMap<String, String> hoods = new HashMap<String, String>();
		
		for (OctTile t : tileset)
		{
			String s = t.edges[i] + " " + t.edges[(i+1)%8] + " " + t.edges[(i+2)%8];
			if (hoods.containsKey(s))
				hoods.put(s, "");
			else
				hoods.put(s, t.name);
		}
		
		HashSet<String> ret = new HashSet<String>();
		
		for (String s : hoods.keySet())
		{
			if (hoods.get(s).length() != 0)
			{
				String[] x = s.split(" ");
				if (!a.contains(x[0] + ' ' + x[1]) && !b.contains(x[1] + ' ' + x[2]))
					ret.add(hoods.get(s) + ' ' + s);
			}
		}
		
		return ret;
	}
	
	static int numCommonEdges(OctTile t1, OctTile t2)
	{
		int r = 0;
		
		for (int k = 0; k < 8; k++)
			r += t1.edges[k].equals(t2.edges[k]) && t1.edges[(k+1)%8].equals(t2.edges[(k+1)%8])? 1 : 0;
		
		return r;
	}
	
	public static void main (String args[])
	{
		TileSet ts = new TileSet ("//Users/alogan/Desktop/myTiles/rt.tds");
		System.out.println(ts.edgebodies[5].get("*").size());
	}
	
}
