//models octagonal tile
class OctTile {

	String name;
	
	//n ne e se s sw w nw
	String[] edges;
	
	boolean isGrowth;
	
	OctTile (String n)
	{
		name = n;
		edges = new String [8];
		
		isGrowth = n.toLowerCase().indexOf("growth") != -1;
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	public String toString()
	{
		return name + "\nN: " + edges[0]
				+ "\nNE: " + edges[1]
						+ "\nE: " + edges[2]
								+ "\nSE: " + edges[3]
										+ "\nS: " + edges[4]
												+ "\nSW: " + edges[5]
														+ "\nW: " + edges[6]
																+ "\nNW: " + edges[7];
	}
}
