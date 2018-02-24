package sensors;

import area.Area;

//Activities which can recognize IDs and cannot move
//Coordinates are optional but they extend the usability of the system
public class StaticActivityGate extends StaticGate{

	private int id;
	private String name;
	private int[] coordinates;
	private Area area;
	
	public StaticActivityGate(int id, String name, int[] coordinates, Area area) {
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
		this.area = area;
	}
	
	public StaticActivityGate(int id, String name, Area area) {
		this.id = id;
		this.name = name;
		coordinates = new int[2];
		coordinates[0] = 0;
		coordinates[1] = 0;
		this.area = area;
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
	public int[] coordinates() {
		return coordinates;
	}

}
