//models aTAM tile
class ATAMTile {

	String name;
	private String color;
	
	private int[] bindings;
	private String[] labels;
	
	ATAMTile (String n, String c, int[] B, String[] L)
	{
		name = n;
		color = c;
		bindings = B;
		labels = L;
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	public boolean equals(Object a2)
	{
		return name.contentEquals(((ATAMTile)a2).name);
	}
	
	public String toString()
	{
		String r = "TILENAME " + name + "\nTILECOLOR " + color + '\n';
		
		if (labels[0] != null)
			r += "NORTHLABEL " + labels[0] + "\nNORTHBIND " + bindings[0] + '\n';
		if (labels[1] != null)
			r += "EASTLABEL " + labels[1] + "\nEASTBIND " + bindings[1] + '\n';
		if (labels[2] != null)
			r += "SOUTHLABEL " + labels[2] + "\nSOUTHBIND " + bindings[2] + '\n';
		if (labels[3] != null)
			r += "WESTLABEL " + labels[3] + "\nWESTBIND " + bindings[3] + '\n';
		
		return r + "CREATE\n\n";
	}
}
