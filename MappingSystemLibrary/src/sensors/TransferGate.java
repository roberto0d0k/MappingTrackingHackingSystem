package sensors;

import area.Area;

//Items which can recognize IDs and identify when Mobiles change areas
//This is almost exclusively for doors
//Coordinates are optional but they extend the usability of the system
public class TransferGate extends StaticGate{

	private int id;
	private String name;
	private int[] coordinates;
	private Area roomA;	//the two rooms this transfer gate is connecting
	private Area roomB;
	
	public TransferGate(int id, String name,  
			Area roomA, Area roomB,int[] coordinates) {
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
		this.roomA = roomA;
		this.roomB = roomB;
		
	}
	
	public TransferGate(int id, String name, Area roomA, Area roomB) {
		this.id = id;
		this.name = name;
		coordinates = new int[1];
		coordinates[0] = 0;
		this.roomA = roomA;
		this.roomB = roomB;
	}
	
	//returns the two areas this transferGate connects
	public Area[] getAreas(){
		Area[] areas = new Area[2];
		areas[0] = roomA;
		areas[1] = roomB;
		return areas;
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
