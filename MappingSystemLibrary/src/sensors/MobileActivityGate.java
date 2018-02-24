package sensors;

import area.Area;

//Activities which can recognize IDs and have their own IDs 
//(they can, and usually move around)
public class MobileActivityGate extends MobileGate{

	private int id;
	private String name;
	private Area area;
	
	public MobileActivityGate(int id, String name, Area area) {
		this.id = id;
		this.name = name;
		this.area = area;
		
		//System.out.println(String.format("MobileActivity Created %d, %s, %s", id,name,area.getName()));
		
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

	@Override
	public boolean isMobileActivityGate() {
		return true;
	}

	@Override
	public boolean isStaticActivityGate() {
		return false;
	}

	@Override
	public boolean isTransferGate() {
		return false;
	}
	
	
	
	
	
	
}
