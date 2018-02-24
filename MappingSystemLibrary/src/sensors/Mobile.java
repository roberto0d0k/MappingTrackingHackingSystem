package sensors;

import area.Area;

//Items (mostly individuals) which have IDs and can move around the space
public class Mobile implements Entity{

	private int id;
	private String name;
	private Area area;
	
	public Mobile(int id, String name) {
		this.id = id;
		this.name = name;
		area = null;
	}
	
	//changes mobiles area
	public void changeArea(Area newArea) {
		area = newArea;
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

	
	
}
