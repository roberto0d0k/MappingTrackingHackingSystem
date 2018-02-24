package sensors;

import area.Area;

//Items which have IDs and can move around the space
public interface Entity extends IDable{
	
	 public String getName(); 
	 public boolean isMobileActivityGate();
	 public Area getArea();
	 public void changeArea(Area newArea);

}
