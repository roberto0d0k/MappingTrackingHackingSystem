package sensors;

import area.Area;

//Items (mostly individuals) which have IDs and can move around the space
public class Mobile implements Entity{

	private int id;
	private String name;
	private Area area;
	private Gate activity;
	
	public Mobile(int id, String name) {
		this.id = id;
		this.name = name;
		area = null;
	}
	
	public Gate getActivity() {
		return activity;
	}
	
	public void setActivity(Gate newActivity) {
		activity = newActivity;
	}
	
	//changes mobiles area
	public void changeArea(Area newArea) {
		//if(area != null && newArea != null)
			//System.out.println("Area was changed from " + area.getName() + " to " + newArea.getName());
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

	@Override
	public boolean isMobileActivityGate() {
		return false;
	}

	
	
}
