package dataStructures;

import java.util.ArrayList;
import sensors.IDable;

public class IDList {

	private ArrayList<IDable> list;
	private int length;
	
	public IDList() {
		list = new ArrayList<IDable>();
		length = 0;
	}
	
	public void add(IDable item) {
		
		int p;
		
		for(p =0; p< length; p++) {
			if(item.getID() < list.get(p).getID()) {
				list.add(p, item);
				length ++;
				break;
			}
		}
		
		list.add(item);
		
	}
	
	//will return null if ID not found
	public IDable getID(int id) {
		for(int p=0; p< length; p++) {
			if(list.get(p).getID()==id) {
				return list.get(p);
			}
		}
		return null;
	}
	
}
