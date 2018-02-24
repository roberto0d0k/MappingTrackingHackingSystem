package area;

import sensors.IDable;

public class Area implements IDable{
	
	private int id;
	private String name;
	private Area encompasingArea; //area this area is inside of
	
	public Area(int id, String name, Area encArea) {
		this.name = name;
		this.id = id;
		encompasingArea = encArea;
	}
	
	public Area(int id, String name) {
		this.name = name;
		this.id = id;
		encompasingArea = null;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Area getEncompasingArea() {
		return encompasingArea;
	}
	
}
