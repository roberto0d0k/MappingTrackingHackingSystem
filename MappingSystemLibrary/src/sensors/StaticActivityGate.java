package sensors;

import area.Area;

//Activities which can recognize IDs and cannot move
//Coordinates are optional but they extend the usability of the system
public class StaticActivityGate extends StaticGate{

	private int id;
	private String name;
	private Area area;
	
	
	public StaticActivityGate(int id, String name, Area area) {
		this.id = id;
		this.name = name;
		this.area = area;
		
		//System.out.println(String.format("StaticActivity Created %d, %s, %s", id,name,area.getName()));
		
	}
	
	//returns mobiles area, returns null if unknown 
		//or not in the space
	public Area getArea() {
		return area;
	}
	
	@Override
	public int getID() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isMobileActivityGate() {
		return false;
	}

	@Override
	public boolean isStaticActivityGate() {
		return true;
	}

	@Override
	public boolean isTransferGate() {
		return false;
	}

}
