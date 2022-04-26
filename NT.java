import java.util.HashSet;
import java.util.LinkedList;

public class NT {
	
	public static void main (String args[])
	{
		TileSet ts = new TileSet ("//Users/alogan/Desktop/tiles.txt");
		
		aTAMTileSet ats = new aTAMTileSet();
		
		//spine
		for (OctTile t : ts.tileset)
		{
			String n = t.name;
			
			ats.addTile(new ATAMTile(n, "gray", new int[] {2, 2, 2, 2}, new String[] {n + ":N", n + ":E", n + ":S", n + ":W"}));
			ats.addTile(new ATAMTile(n + ":(0,1)\n", "yellow", new int[] {2, 0, 2, 0}, new String[] {n + ":(0,1)[N]", null, n + ":N", null}));
			ats.addTile(new ATAMTile(n + ":(0,-1)\n", "yellow", new int[] {2, 0, 2, 0}, new String[] {n + ":S", null, n + ":(0,-1)[S]", null}));
			ats.addTile(new ATAMTile(n + ":(0,2)\n", "yellow", new int[] {2, 2, 2, 2}, new String[] {n + ":(0,2)[N]", n + ":(0,2)[E]", n + ":(0,1)[N]", n + ":(0,2)[W]"}));
			ats.addTile(new ATAMTile(n + ":(0,-2)\n", "yellow", new int[] {2, 2, 2, 2}, new String[] {n + ":(0,-1)[S]", n + ":(0,-2)[E]", n + ":(0,-2)[S]", n + ":(0,-2)[W]"}));
		}
				
		//north arm
		{
			for (String s : ts.edgesets[0])
			{
				ats.addTile(new ATAMTile (s + ":(0,4)", "white", new int[] {2,0,2,0}, new String[] {s+":(0,4)[N]", null, s+":(0,3)[N]", null}));
				ats.addTile(new ATAMTile (s + ":(0,5)", "white", new int[] {2,0,2,0}, new String[] {s+":(0,5)[N]", null, s+":(0,4)[N]", null}));
				ats.addTile(new ATAMTile (s + ":(0,-4)in", "white", new int[] {0,1,2,1}, new String[] {null, s+":(0,-4)[E]", s+":(0,5)[N]", s+":(0,-4)[W]"}));
			}
		}
				
		//east arm
		{
			for (String s : ts.edgesets[2])
			{
				ats.addTile(new ATAMTile (s + ":(2,0)", "white", new int[] {0,2,0,2}, new String[] {null, s+":(2,0)[E]", null, s+":(1,0)[E]"}));
				ats.addTile(new ATAMTile (s + ":(3,0)", "white", new int[] {0,2,0,2}, new String[] {null, s+":(3,0)[E]", null, s+":(2,0)[E]"}));
				ats.addTile(new ATAMTile (s + ":(-2,0)in", "white", new int[] {1,0,1,2}, new String[] {s+":(-2,0)[N]", null, s+":(-2,0)[S]", s+":(3,0)[E]"}));
			}
		}
		
		//south arm
		{
			for (String s : ts.edgesets[4])
			{
				ats.addTile(new ATAMTile (s + ":(0,-4)", "white", new int[] {2,0,2,0}, new String[] {s+":(0,-3)[S]", null, s+":(0,-4)[S]", null}));
				ats.addTile(new ATAMTile (s + ":(0,-5)", "white", new int[] {2,0,2,0}, new String[] {s+":(0,-4)[S]", null, s+":(0,-5)[S]", null}));
				ats.addTile(new ATAMTile (s + ":(0,4)in", "white", new int[] {2,1,0,1}, new String[] {s+":(0,-5)[S]", s+":(0,4)[E]", null, s+":(0,4)[W]"}));
			}
		}
				
		//west arm
		{
			for (String s : ts.edgesets[6])
			{
				ats.addTile(new ATAMTile (s + ":(-2,0)", "white", new int[] {0,2,0,2}, new String[] {null, s+":(-1,0)[W]", null, s+":(-2,0)[W]"}));
				ats.addTile(new ATAMTile (s + ":(-3,0)", "white", new int[] {0,2,0,2}, new String[] {null, s+":(-2,0)[W]", null, s+":(-3,0)[W]"}));
				ats.addTile(new ATAMTile (s + ":(2,0)in", "white", new int[] {1,2,1,0}, new String[] {s+":(2,0)[N]", s+":(-3,0)[W]", s+":(2,0)[S]", null}));
			}
		}
				
				
		//ne arm
		{
			for(String s : ts.edgesets[1])
			{
				ats.addTile(new ATAMTile (s + ":(2,2)", "white", new int[] {2,0,0,2}, new String[] {s + ":(2,2)[N]", null, null, s+":(1,2)[E]"}));
				ats.addTile(new ATAMTile (s + ":(2,3)", "white", new int[] {2,0,2,0}, new String[] {s + ":(2,3)[N]", null, s + ":(2,2)[N]", null}));
				ats.addTile(new ATAMTile (s + ":(2,4)", "white", new int[] {2,0,2,0}, new String[] {s + ":(2,4)[N]", null, s + ":(2,3)[N]", null}));
				ats.addTile(new ATAMTile (s + ":(2,5)", "white", new int[] {0,1,2,0}, new String[] {null, s + ":(2,5)[E]", s + ":(2,4)[N]", null}));
				ats.addTile(new ATAMTile (s + ":(-2,-5)in", "white", new int[] {2,0,0,2}, new String[] {s +":(-2,-5)[N]", null, null, s + ":(-2,-5)gen[W]"}));
				ats.addTile(new ATAMTile (s + ":(-2,-4)in", "white", new int[] {2,1,2,0}, new String[] {s + ":(-2,-4)[N]", s + ":(-2,-4)[E]", s + ":(-2,-5)[N]", null}));
				ats.addTile(new ATAMTile (s + ":(-2,-3)in", "white", new int[] {2,0,2,0}, new String[] {s + ":(-2,-3)[N]", null, s + ":(-2,-4)[N]", null}));
				ats.addTile(new ATAMTile (s + ":(-2,-2)in", "white", new int[] {1,0,2,0}, new String[] {s + ":(-2,-2)[N]", null, s + ":(-2,-3)[N]", null}));
			}
		}
				
		//nw arm
		{
			for (String s : ts.edgesets[7])
			{
				ats.addTile(new ATAMTile (s + ":(-2,2)", "white", new int[] {2,2,0,0}, new String[] {s + ":(-2,2)[N]", s + ":(-1,2)[W]", null, null}));
				ats.addTile(new ATAMTile (s + ":(-2,3)", "white", new int[] {2,0,2,0}, new String[] {s + ":(-2,3)[N]", null, s + ":(-2,2)[N]", null}));
				ats.addTile(new ATAMTile (s + ":(-2,4)", "white", new int[] {0,0,2,2}, new String[] {null, null, s + ":(-2,3)[N]", s +":(-2,4)[W]"}));
				ats.addTile(new ATAMTile (s + ":(-3,4)", "white", new int[] {1,2,0,0}, new String[] {s + ":(-3,4)[N]", s + ":(-2,4)[W]", null, null}));
				ats.addTile(new ATAMTile (s + ":(3,-4)in", "white", new int[] {0,0,2,2}, new String[] {null, null, s + ":(3,-4)gen[S]", s + ":(3,-4)[W]"}));
				ats.addTile(new ATAMTile (s + ":(2,-4)in", "white", new int[] {2,2,0,1}, new String[] {s + ":(2,-4)[N]", s + ":(3,-4)[W]", null, s + ":(2,-4)[W]"}));
				ats.addTile(new ATAMTile (s + ":(2,-3)in", "white", new int[] {2,0,2,0}, new String[] {s + ":(2,-3)[N]", null, s + ":(2,-4)[N]", null}));
				ats.addTile(new ATAMTile (s + ":(2,-2)in", "white", new int[] {1,0,2,0}, new String[] {s + ":(2,-2)[N]", null, s + ":(2,-3)[N]", null}));
			}
		}
				
		//sw arm
		{
			for (String s : ts.edgesets[5])
			{
				ats.addTile(new ATAMTile (s + ":(-2,-2)", "white", new int[] {0,2,2,0}, new String[] {null, s + ":(-1,-2)[W]", s + ":(-2,-2)[S]", null}));
				ats.addTile(new ATAMTile (s + ":(-2,-3)", "white", new int[] {2,0,2,0}, new String[] {s + ":(-2,-2)[S]", null, s + ":(-2,-3)[S]", null}));
				ats.addTile(new ATAMTile (s + ":(-2,-4)", "white", new int[] {2,0,2,0}, new String[] {s + ":(-2,-3)[S]", null, s + ":(-2,-4)[S]", null}));
				ats.addTile(new ATAMTile (s + ":(-2,-5)", "white", new int[] {2,0,0,1}, new String[] {s + ":(-2,-4)[S]", null, null, s + ":(-2,-5)[W]"}));
				ats.addTile(new ATAMTile (s + ":(2,5)in", "white", new int[] {0,2,2,0}, new String[] {null, s + ":(2,5)gen[E]", s + ":(2,5)[S]", null}));
				ats.addTile(new ATAMTile (s + ":(2,4)in", "white", new int[] {2,0,2,1}, new String[] {s + ":(2,5)[S]", null, s + ":(2,4)[S]", s + ":(2,4)[W]"}));
				ats.addTile(new ATAMTile (s + ":(2,3)in", "white", new int[] {2,0,2,0}, new String[] {s + ":(2,4)[S]", null, s + ":(2,3)[S]", null}));
				ats.addTile(new ATAMTile (s + ":(2,2)in", "white", new int[] {2,0,1,0}, new String[] {s + ":(2,3)[S]", null, s + ":(2,2)[S]", null}));
			}
		}
				
		//se arm
		{
			for (String s : ts.edgesets[3])
			{
				ats.addTile(new ATAMTile (s + ":(2,-2)", "white", new int[] {0,0,2,2}, new String[] {null, null, s + ":(2,-2)[S]", s + ":(1,-2)[E]"}));
				ats.addTile(new ATAMTile (s + ":(2,-3)", "white", new int[] {2,0,2,0}, new String[] {s + ":(2,-2)[S]", null, s + ":(2,-3)[S]", null}));
				ats.addTile(new ATAMTile (s + ":(2,-4)", "white", new int[] {2,2,0,0}, new String[] {s + ":(2,-3)[S]", s + ":(2,-4)[E]", null, null}));
				ats.addTile(new ATAMTile (s + ":(3,-4)", "white", new int[] {0,0,1,2}, new String[] {null, null, s + ":(3,-4)[S]", s + ":(2,-4)[E]"}));
				ats.addTile(new ATAMTile (s + ":(-3,4)in", "white", new int[] {2,2,0,0}, new String[] {s + ":(-3,4)gen[N]", s + ":(-3,4)[E]", null, null}));
				ats.addTile(new ATAMTile (s + ":(-2,4)in", "white", new int[] {0,1,2,2}, new String[] {null, s + ":(-2,4)[E]", s + ":(-2,4)[S]", s + ":(-3,4)[E]"}));
				ats.addTile(new ATAMTile (s + ":(-2,3)in", "white", new int[] {2,0,2,0}, new String[] {s + ":(-2,4)[S]", null, s + ":(-2,3)[S]", null}));
				ats.addTile(new ATAMTile (s + ":(-2,2)in", "white", new int[] {2,0,1,0}, new String[] {s + ":(-2,3)[S]", null, s + ":(-2,2)[S]", null}));
			}
		}

			
			//n-ne 2-forcures
			for (String s : ts.unique2hoods(0))
			{
				String[] n = s.split(" ");

				ats.addTile(new ATAMTile(n[1] + '+' + n[2] + ":(1,4)", "red", new int[] {0, 1, 2, 1}, new String[] {null, n[2] + ":(2,4)[W]", n[1]+'+'+n[2] + ":(1,4)[S]", n[1] + ":(0,4)[E]"}));
				ats.addTile(new ATAMTile(n[1] + '+' + n[2] + ":(1,3)", "red", new int[] {2, 0, 0, 2}, new String[] {n[1]+'+'+n[2] + ":(1,4)[S]", null, null, n[0] + ":(0,3)[E]"}));
				ats.addTile(new ATAMTile("2F0-" + n[0] + ":(0,3)", "blue", new int[] {2, 2, 2, 0}, new String[] {ts.getTile(n[0]).edges[0] + ":(0,3)[N]", n[0] + ":(0,3)[E]", n[0]+":(0,2)[N]", null}));
			}
			
			//ne-e 2-forcures
			for (String s : ts.unique2hoods(1))
			{
				String[] n = s.split(" ");
				
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(2,1)", "red", new int[] {1,0,1,2}, new String[] {n[1]+":(2,2)[S]", null, n[2]+":(2,0)[N]", n[1]+'+'+n[2]+":(2,1)[W]"}));
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(1,1)", "red", new int[] {0,2,2,0}, new String[] {null, n[1]+'+'+n[2]+":(2,1)[W]", n[0]+":(1,0)[N]", null}));
				ats.addTile(new ATAMTile("2F1-" + n[0]+":(1,0)", "blue", new int[] {2,2,0,2}, new String[] {n[0]+":(1,0)[N]", ts.getTile(n[0]).edges[2] + ":(1,0)[E]", null, n[0] + ":E"}));
			}
			
			//e-se 2-forcures
			for (String s : ts.unique2hoods(2))
			{
				String[] n = s.split(" ");
				
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(2,-1)", "red", new int[] {1,0,1,2}, new String[] {n[1]+":(2,0)[S]", null, n[2]+":(2,-2)[N]", n[1]+'+'+n[2]+":(2,-1)[W]"}));
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(1,-1)", "red", new int[] {2,2,0,0}, new String[] {n[0] + ":(1,0)[S]", n[1]+'+'+n[2]+":(2,-1)[W]", null, null}));
				ats.addTile(new ATAMTile("2F2-"+n[0]+":(1,0)", "blue", new int[] {0,2,2,2}, new String[] {null, ts.getTile(n[0]).edges[2] + ":(1,0)[E]", n[0]+":(1,0)[S]", n[0]+":E"}));
			}
			
			//se-s 2-forcures
			for (String s : ts.unique2hoods(3))
			{
				String[] n = s.split(" ");
				
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(1,-4)", "red", new int[] {2,1,0,1}, new String[] {n[1]+'+'+n[2]+":(1,-4)[N]", n[1]+":(2,-4)[W]", null, n[2]+":(0,-4)[E]"}));
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(1,-3)", "red", new int[] {0,0,2,2}, new String[] {null, null, n[1]+'+'+n[2]+":(1,-4)[N]", n[0]+":(0,-3)[E]"}));
				ats.addTile(new ATAMTile("2F3-" + n[0]+":(0,-3)", "blue", new int[] {2,2,2,0}, new String[] {n[0] + ":(0,-2)[S]", n[0]+":(0,-3)[E]", ts.getTile(n[0]).edges[4]+":(0,-3)[S]", null}));
			}
			
			//s-sw 2-forcures
			for (String s : ts.unique2hoods(4))
			{
				String[] n = s.split(" ");
				
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,-4)", "red", new int[] {2,1,0,1}, new String[] {n[1]+'+'+n[2]+":(-1,-4)[N]", n[1]+":(0,-4)[W]", null, n[2]+":(-2,-4)[E]"}));
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,-3)", "red", new int[] {0,2,2,0}, new String[] {null, n[0] + ":(0,-3)[W]", n[1]+'+'+n[2]+":(-1,-4)[N]", null}));
				ats.addTile(new ATAMTile("2F4-" + n[0]+":(0,-3)", "blue", new int[] {2,0,2,2}, new String[] {n[0]+":(0,-2)[S]", null, ts.getTile(n[0]).edges[4]+":(0,-3)[S]", n[0]+":(0,-3)[W]"}));
			}
			
			//sw-w 2-forcures
			for (String s : ts.unique2hoods(5))
			{
				String[] n = s.split(" ");
				
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-2,-1)", "red", new int[] {1,2,1,0}, new String[] {n[2]+":(-2,0)[S]", n[1]+'+'+n[2]+":(-2,-1)[E]", n[1]+":(-2,-2)[N]", null}));
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,-1)", "red", new int[] {2,0,0,2}, new String[] {n[0]+":(-1,0)[S]", null, null, n[1] + '+' + n[2] + ":(-2,-1)[E]"}));
				ats.addTile(new ATAMTile("2F5-" + n[0]+":(-1,0)", "blue", new int[] {0,2,2,2}, new String[] {null, n[0]+":W", n[0]+":(-1,0)[S]", ts.getTile(n[0]).edges[6]+":(-1,0)[W]"}));
			}
			
			//w-nw 2-forcures
			for (String s : ts.unique2hoods(6))
			{
				String[] n = s.split(" ");
				
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-2,1)", "red", new int[] {1,2,1,0}, new String[] {n[2]+":(-2,2)[S]", n[1]+'+'+n[2]+":(-2,1)[E]", n[1]+":(-2,0)[N]", null}));
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,1)", "red", new int[] {0,0,2,2}, new String[] {null, null, n[0]+":(-1,0)[N]", n[1] + '+' + n[2] + ":(-2,1)[E]"}));
				ats.addTile(new ATAMTile("2F6-" + n[0]+":(-1,0)", "blue", new int[] {2,2,0,2}, new String[] {n[0]+":(-1,0)[N]", n[0]+":W", null, ts.getTile(n[0]).edges[6]+":(-1,0)[W]"}));
			}
			
			//nw-n 2-forcures
			for (String s : ts.unique2hoods(7))
			{
				String[] n = s.split(" ");
				
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,4)", "red", new int[] {0,1,2,1}, new String[] {null, n[2]+":(0,4)[W]", n[1]+'+'+n[2]+":(-1,4)[S]", n[1]+":(-2,4)[E]"}));
				ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,3)", "red", new int[] {2,2,0,0}, new String[] {n[1]+'+'+n[2]+":(-1,4)[S]", n[0]+":(-1,3)[E]", null, null}));
				ats.addTile(new ATAMTile("2F7-" + n[0] + ":(0,3)", "blue", new int[] {2, 0, 2, 2}, new String[] {ts.getTile(n[0]).edges[0] + ":(0,3)[N]", null, n[0]+":(0,2)[N]", n[0]+":(-1,3)[E]"}));
			}
			
			//n-ne-e 3-forcures
			{
				HashSet<String> x = ts.unique3hoods(0);
				
				for (String s : x)
				{
					String[] n = s.split(" ");
					
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(1,4)", "red", new int[] {0,1,2,1}, new String[] {null, n[2]+":(2,4)[W]", n[1]+'+'+n[2]+":(1,4)[S]", n[1]+":(0,4)[E]"}));
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(1,3)", "red", new int[] {2,0,1,1}, new String[] {n[1] + '+' + n[2] + ":(1,4)[S]", null, n[1]+'+'+n[2]+":(1,3)[S]", n[1]+'+'+n[2]+":(1,3)[W]"}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(2,1)", "red", new int[] {1,0,1,2}, new String[] {n[2] + ":(2,2)[S]", null, n[3] + ":(2,0)[N]", n[2]+'+'+n[3]+":(2,1)[W]"}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(1,1)", "red", new int[] {1,2,1,0}, new String[] {n[2]+'+'+n[3]+":(1,1)[N]", n[2]+'+'+n[3]+":(2,1)[W]", n[2]+'+'+n[3]+":(1,1)[S]", null}));
					ats.addTile(new ATAMTile(n[0] + ":(1,2)", "blue", new int[] {1,2,1,2}, new String[] {n[1]+'+'+n[2]+":(1,3)[S]", ts.getTile(n[0]).edges[1]+":(1,2)[E]", n[2]+'+'+n[3]+":(1,1)[N]", n[0] + ":(0,2)[E]"}));
				}
			}
			
			//ne-e-se 3-forcures
			{
				HashSet<String> x = ts.unique3hoods(1);
				
				for (String s : x)
				{
					String[] n = s.split(" ");

					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(2,1)", "red", new int[] {1,0,1,2}, new String[] {n[1] + ":(2,2)[S]", null, n[2] + ":(2,0)[N]", n[1]+'+'+n[2]+":(2,1)[W]"}));
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(1,1)", "red", new int[] {1,2,1,0}, new String[] {n[1]+'+'+n[2]+":(1,1)[N]", n[1]+'+'+n[2]+":(2,1)[W]", n[1]+'+'+n[2]+":(1,1)[S]", null}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(2,-1)", "red", new int[] {1,0,1,2}, new String[] {n[2] + ":(2,0)[S]", null, n[3] + ":(2,-2)[N]", n[2]+'+'+n[3]+":(2,-1)[W]"}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(1,-1)", "red", new int[] {1,2,1,0}, new String[] {n[2]+'+'+n[3]+":(1,-1)[N]", n[2]+'+'+n[3]+":(2,-1)[W]", n[2]+'+'+n[3]+":(1,-1)[S]", null}));
					ats.addTile(new ATAMTile(n[0] + ":(1,0)", "blue", new int[] {1,2,1,2}, new String[] {n[1]+'+'+n[2]+":(1,1)[S]", ts.getTile(n[0]).edges[2]+":(1,0)[E]", n[2]+'+'+n[3]+":(1,-1)[N]", n[0]+":E"}));
				}
				
				
			}
			
			//e-se-s 3-forcures
			{
				HashSet<String> x = ts.unique3hoods(2);
				
				for (String s : x)
				{
					String[] n = s.split(" ");
				
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(2,-1)", "red", new int[] {1,0,1,2}, new String[] {n[1] + ":(2,0)[S]", null, n[2] + ":(2,-2)[N]", n[1]+'+'+n[2]+":(2,-1)[W]"}));
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(1,-1)", "red", new int[] {1,2,1,0}, new String[] {n[1]+'+'+n[2]+":(1,-1)[N]", n[1]+'+'+n[2]+":(2,-1)[W]", n[1]+'+'+n[2]+":(1,-1)[S]", null}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(1,-4)", "red", new int[] {2,1,0,1}, new String[] {n[2]+'+'+n[3]+":(1,-4)[N]", n[2]+":(2,-4)[W]", null, n[3]+":(0,-4)[E]"}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(1,-3)", "red", new int[] {1,0,2,1}, new String[] {n[2]+'+'+n[3]+":(1,-3)[N]", null, n[2]+'+'+n[3]+":(1,-4)[N]", n[2]+'+'+n[3]+":(1,-3)[W]"}));
					ats.addTile(new ATAMTile(n[0]+":(1,-2)", "blue", new int[] {1,2,1,2}, new String[] {n[1]+'+'+n[2]+":(1,-1)[S]", ts.getTile(n[0]).edges[3] +":(1,-2)[E]", n[2]+'+'+n[3]+":(1,-3)[N]", n[0]+":(0,-2)[E]"}));
				}
			}
			
			//se-s-sw 3-forcures
			{
				HashSet<String> x = ts.unique3hoods(3);
				
				for (String s : x)
				{
					String[] n = s.split(" ");

					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(1,-4)", "red", new int[] {2,1,0,1}, new String[] {n[1]+'+'+n[2]+":(1,-4)[N]", n[1]+":(2,-4)[W]", null, n[2]+":(0,-4)[E]"}));
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(1,-3)", "red", new int[] {1,0,2,1}, new String[] {n[1]+'+'+n[2]+":(1,-3)[N]", null, n[1]+'+'+n[2]+":(1,-4)[N]", n[1]+'+'+n[2]+":(1,-3)[W]"}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(-1,-4)", "red", new int[] {2,1,0,1}, new String[] {n[2]+'+'+n[3]+":(-1,-4)[N]", n[2]+":(0,-4)[W]", null, n[3]+":(-2,-4)[E]"}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(-1,-3)", "red", new int[] {1,1,2,0}, new String[] {n[2]+'+'+n[3]+":(-1,-3)[N]", n[2]+'+'+n[3]+":(-1,-3)[E]", n[2]+'+'+n[3]+":(-1,-4)[N]", null}));
					ats.addTile(new ATAMTile(n[0]+":(0,-3)", "blue", new int[] {2,1,2,1}, new String[] {n[0] + ":(0,-2)[S]", n[1]+'+'+n[2]+":(1,-3)[W]", ts.getTile(n[0]).edges[4]+":(0,-3)[S]", n[2]+'+'+n[3]+":(-1,-3)[E]"}));
				}
			}
				
			//s-sw-w 3-forcures
			{
				HashSet<String> x = ts.unique3hoods(4);
				
				for (String s : x)
				{
					String[] n = s.split(" ");

					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,-4)", "red", new int[] {2,1,0,1}, new String[] {n[1]+'+'+n[2]+":(-1,-4)[N]", n[1]+":(0,-4)[W]", null, n[2]+":(-2,-4)[E]"}));
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,-3)", "red", new int[] {1,1,2,0}, new String[] {n[1]+'+'+n[2]+":(-1,-3)[N]", n[1]+'+'+n[2]+":(-1,-3)[E]", n[1]+'+'+n[2]+":(-1,-4)[N]", null}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(-2,-1)", "red", new int[] {1,2,1,0}, new String[] {n[3] +":(-2,0)[S]", n[2]+'+'+n[3]+":(-2,-1)[E]", n[2]+":(-2,-2)[N]", null}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(-1,-1)", "red", new int[] {1,0,1,2}, new String[] {n[2]+'+'+n[3]+":(-1,-1)[N]", null, n[2]+'+'+n[3]+":(-1,-1)[S]", n[2]+'+'+n[3]+":(-2,-1)[E]"}));
					ats.addTile(new ATAMTile(n[0] +":(-1,-2)", "blue", new int[] {1,2,1,2}, new String[] {n[2]+'+'+n[3]+":(-1,-1)[S]", n[0] + ":(0,-2)[W]", n[1]+'+'+n[2]+":(-1,-3)[N]", ts.getTile(n[0]).edges[5]+":(-1,-2)[W]"}));
				}
			}
			
			//sw-w-nw 3-forcures
			{
				HashSet<String> x = ts.unique3hoods(5);
				
				for (String s : x)
				{
					String[] n = s.split(" ");
					
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-2,-1)", "red", new int[] {1,2,1,0}, new String[] {n[2] +":(-2,0)[S]", n[1]+'+'+n[2]+":(-2,-1)[E]", n[1]+":(-2,-2)[N]", null}));
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,-1)", "red", new int[] {1,0,1,2}, new String[] {n[1]+'+'+n[2]+":(-1,-1)[N]", null, n[1]+'+'+n[2]+":(-1,-1)[S]", n[1]+'+'+n[2]+":(-2,-1)[E]"}));
					ats.addTile(new ATAMTile(n[2] + '+' + n[3] + ":(-2,1)", "red", new int[] {1,2,1,0}, new String[] {n[3] + ":(-2,2)[S]", n[2]+'+'+n[3]+":(-2,1)[E]", n[2]+":(-2,0)[N]", null}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(-1,1)", "red", new int[] {1,0,1,2}, new String[] {n[2]+'+'+n[3]+":(-1,1)[S]", null, n[2]+'+'+n[3]+":(-1,1)[S]", n[2]+'+'+n[3]+":(-2,1)[E]"}));
					ats.addTile(new ATAMTile(n[0] + ":(-1,0)", "blue", new int[] {1,2,1,2}, new String[] {n[2]+'+'+n[3]+":(-1,1)[S]", n[0]+":W", n[1]+'+'+n[2]+":(-1,-1)[N]", ts.getTile(n[0]).edges[6] + ":(-1,0)[W]"}));
				}
			}
			
			//w-nw-n 3-forcures
			{
				HashSet<String> x = ts.unique3hoods(6);
				
				for (String s : x)
				{
					String[] n = s.split(" ");

					ats.addTile(new ATAMTile(n[1] + '+' + n[2] + ":(-2,1)", "red", new int[] {1,2,1,0}, new String[] {n[2] + ":(-2,2)[S]", n[1]+'+'+n[2]+":(-2,1)[E]", n[1]+":(-2,0)[N]", null}));
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,1)", "red", new int[] {1,0,1,2}, new String[] {n[1]+'+'+n[2]+":(-1,1)[N]", null, n[1]+'+'+n[2]+":(-1,1)[S]", n[1]+'+'+n[2]+":(-2,1)[E]"}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(-1,4)", "red", new int[] {0,1,2,1}, new String[] {null, n[3]+":(0,4)[W]", n[2]+'+'+n[3]+":(-1,4)[S]", n[2]+":(-2,4)[E]"}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(-1,3)", "red", new int[] {2,1,1,0}, new String[] {n[2]+'+'+n[3]+":(-1,4)[S]", n[2]+'+'+n[3]+":(-1,3)[E]", n[2]+'+'+n[3]+":(-1,3)[S]", null}));
					ats.addTile(new ATAMTile(n[0] + ":(-1,2)", "blue", new int[] {1,2,1,2}, new String[] {n[2]+'+'+n[3]+":(-1,3)[S]", n[0] + ":(0,2)[W]", n[1]+'+'+n[2]+":(-1,1)[N]", ts.getTile(n[0]).edges[7]+":(-1,2)[W]"}));
				}
			}
			
			//nw-n-ne 3-forcures
			{
				HashSet<String> x = ts.unique3hoods(7);
				
				for (String s : x)
				{
					String[] n = s.split(" ");
					

					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,4)", "red", new int[] {0,1,2,1}, new String[] {null, n[2]+":(0,4)[W]", n[1]+'+'+n[2]+":(-1,4)[S]", n[1]+":(-2,4)[E]"}));
					ats.addTile(new ATAMTile(n[1]+'+'+n[2]+":(-1,3)", "red", new int[] {2,1,1,0}, new String[] {n[1]+'+'+n[2]+":(-1,4)[S]", n[1]+'+'+n[2]+":(-1,3)[E]", n[1]+'+'+n[2]+":(-1,3)[S]", null}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(1,4)", "red", new int[] {0,1,2,1}, new String[] {null, n[3]+":(2,4)[W]", n[2]+'+'+n[3]+":(1,4)[S]", n[2]+":(0,4)[E]"}));
					ats.addTile(new ATAMTile(n[2]+'+'+n[3]+":(1,3)", "red", new int[] {2,0,1,1}, new String[] {n[2] + '+' + n[3] + ":(1,4)[S]", null, n[2]+'+'+n[3]+":(1,3)[S]", n[2]+'+'+n[3]+":(1,3)[W]"}));
					ats.addTile(new ATAMTile(n[0] + ":(0,3)", "blue", new int[] {2,1,2,1}, new String[] {ts.getTile(n[0]).edges[0]+":(0,3)[N]", n[2]+'+'+n[3]+":(1,3)[W]", n[0]+":(0,2)[N]", n[1]+'+'+n[2]+":(-1,3)[E]"}));
				}
			}
			
			//fill in remaining nubs
			{
				for (OctTile t : ts.tileset)
				{
					ATAMTile a = new ATAMTile (t.name+ ":(0,3)", "orange", new int[] {2,0,2,0}, new String[] {t.edges[0]+":(0,3)[N]", null, t.name+":(0,2)[N]", null});
					if (!ats.tileset.contains(a))
						ats.addTile(a);

					ATAMTile b = new ATAMTile (t.name+ ":(1,2)", "orange", new int[] {0,2,0,2}, new String[] {null, t.edges[1]+":(1,2)[E]", null, t.name+":(0,2)[E]"});
					if (!ats.tileset.contains(b))
						ats.addTile(b);

					ATAMTile c = new ATAMTile (t.name+ ":(1,0)", "orange", new int[] {0,2,0,2}, new String[] {null, t.edges[2]+":(1,0)[E]", null, t.name+":E"});
					if (!ats.tileset.contains(c))
						ats.addTile(c);

					ATAMTile d = new ATAMTile (t.name+ ":(1,-2)", "orange", new int[] {0,2,0,2}, new String[] {null, t.edges[3]+":(1,-2)[E]", null, t.name+":(0,-2)[E]"});
					if (!ats.tileset.contains(d))
						ats.addTile(d);
					
					ATAMTile e = new ATAMTile (t.name+ ":(0,-3)", "orange", new int[] {2,0,2,0}, new String[] {t.name+":(0,-2)[S]", null, t.edges[4]+":(0,-3)[S]", null});
					if (!ats.tileset.contains(e))
						ats.addTile(e);

					ATAMTile f = new ATAMTile (t.name+ ":(-1,-2)", "orange", new int[] {0,2,0,2}, new String[] {null, t.name+":(0,-2)[W]", null, t.edges[5]+":(-1,-2)[W]"});
					if (!ats.tileset.contains(f))
						ats.addTile(f);

					ATAMTile g = new ATAMTile (t.name+ ":(-1,0)", "orange", new int[] {0,2,0,2}, new String[] {null, t.name+":W", null, t.edges[6]+":(-1,0)[W]"});
					if (!ats.tileset.contains(g))
						ats.addTile(g);

					ATAMTile h = new ATAMTile (t.name+ ":(-1,2)", "orange", new int[] {0,2,0,2}, new String[] {null, t.name+":(0,2)[W]", null, t.edges[7]+":(-1,2)[W]"});
					if (!ats.tileset.contains(h))
						ats.addTile(h);
				}
			}
			
			
			//junctions
			{
				HashSet[] j = ts.junctions();
				
				j[2].add("SeedM_3-SEED" + ' ' + "CGG1_0-SEED");
				j[2].add("CGG1_0-SEED" + ' ' + "SeedP_5-SEED");
				j[3].add("SeedP_5-SEED" + ' ' + "CBG_7-SEED");
				j[3].add("CBG_7-SEED" + ' ' + "SeedP_0-SEED");
				j[0].add("SeedP_1-SEED" + ' ' + "CBG_3-SEED");
				j[0].add("CBG_3-SEED" + ' ' + "SeedP_0-SEED");
				j[1].add("SeedM_3-SEED" + ' ' + "CGGk_4-SEED");
				j[1].add("CGGk_4-SEED" + ' ' + "SeedP_1-SEED");
				
				for (String s : (HashSet<String>)(j[0]))
				{
					String[] n = s.split(" ");
					ats.addTile(new ATAMTile (n[0]+'+'+n[1]+"jN", "green", new int[] {1,1,2,2}, new String[] {n[0]+":(3,-4)[S]", n[1]+":(-2,-5)[W]", n[0]+":(-3,4)gen[N]", n[1]+":(2,5)gen[E]"}));
				}
				
				for (String s : (HashSet<String>)(j[1]))
				{
					String[] n = s.split(" ");
					ats.addTile(new ATAMTile (n[0]+'+'+n[1]+"jE", "green", new int[] {2,1,1,2}, new String[] {n[1]+":(3,-4)gen[S]", n[0]+":(-2,-5)[W]", n[1]+":(-3,4)[N]", n[0]+":(2,5)gen[E]"}));
				}
				
				for (String s : (HashSet<String>)(j[2]))
				{
					String[] n = s.split(" ");
					ats.addTile(new ATAMTile (n[0]+'+'+n[1]+"jS", "green", new int[] {2,2,1,1}, new String[] {n[1]+":(3,-4)gen[S]", n[0]+":(-2,-5)gen[W]", n[1]+":(-3,4)[N]", n[0]+":(2,5)[E]"}));
				}
				
				for (String s : (HashSet<String>)(j[3]))
				{
					String[] n = s.split(" ");
					ats.addTile(new ATAMTile (n[0]+'+'+n[1]+"jW", "green", new int[] {1,2,2,1}, new String[] {n[0]+":(3,-4)[S]", n[1]+":(-2,-5)gen[W]", n[0]+":(-3,4)gen[N]", n[1]+":(2,5)[E]"}));
				}
			}
			
		ats.writeTDS("//Users/alogan/Desktop/TESTING/frt.tds");
	}
	
}
