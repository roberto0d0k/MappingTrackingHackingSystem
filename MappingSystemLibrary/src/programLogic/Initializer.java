package programLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import area.Area;
import dataStructures.IDList;
import sensors.Mobile;
import sensors.MobileActivityGate;
import sensors.StaticActivityGate;
import sensors.TransferGate;

//README Controller contains a list with all your items organized by ids
//Make sure you double check how your files will be initialized

public class Initializer {

	private static final String SPLITTER = "\'";
	private static final String COORDINATE_SPLITTER = ",";
	
	private static Scanner ini;
	
	public static void initializeAll() {
		
		File file;
		Controller.list = new IDList();
		
		//Areas
		file=new File("DatabaseTemporaryStorage/Input/InitializerFiles/Room");
		initializeAreas(file);
		
		//Activities
		file=new File("DatabaseTemporaryStorage/Input/InitializerFiles/Activity");
		initializeActivities(file);
		
		//Mobiles
		file=new File("DatabaseTemporaryStorage/Input/InitializerFiles/Mobile");
		initializeMobiles(file);
		
		//TransferGates
		file=new File("DatabaseTemporaryStorage/Input/InitializerFiles/TransferGate");
		initializeTransferGates(file);
			
	}
	
	private static void initializeActivities(File file) {
		
		try {
			ini = new Scanner(file);
		} catch (FileNotFoundException e) {
			// FAILED TO FILD FILE
			e.printStackTrace();
			return;
		}
		
		String temp[];
		
		//go line by line and initialize all variables
		while(ini.hasNextLine()) {
		
			try {
				
				//Split line into elements
				temp = ini.nextLine().split(SPLITTER);
				
				//if it is static initialize a static
				if(temp[2].equals("1")) {
					Controller.list.add( new StaticActivityGate(Integer.parseInt(temp[0]),
							temp[1], (Area)Controller.list.getID(Integer.parseInt(temp[3]))));
				}else {
					//if its not static initialize
					Controller.list.add( new MobileActivityGate(Integer.parseInt(temp[0]),
							temp[1], (Area)Controller.list.getID(Integer.parseInt(temp[3]))));
				}
				
			}catch(Exception e) {
				//Incorrect formatting of file
				e.printStackTrace();
				continue;
			}
		}
		
	}
	
	private static void initializeMobiles(File file) {
		
		try {
			ini = new Scanner(file);
		} catch (FileNotFoundException e) {
			// FAILED TO FILD FILE
			e.printStackTrace();
			return;
		}
		
		String temp[];
		
		while(ini.hasNextLine()) {

			try {

				//Split line into elements
				temp = ini.nextLine().split(SPLITTER);
				
				Controller.list.add(new Mobile(Integer.parseInt(temp[0]),
						temp[1]));
	
			}catch(Exception e) {
				//Incorrect formatting of file
				e.printStackTrace();
				continue;
			}
			
		}
		
	}
	
	//Rooms are areas
	private static void initializeAreas(File file) {
		
		try {
			ini = new Scanner(file);
		} catch (FileNotFoundException e) {
			// FAILED TO FILD FILE
			e.printStackTrace();
			return;
		}
		
		String[] temp;
		
		while(ini.hasNextLine()) {
			
			try {

				//Split line into elements
				temp = ini.nextLine().split(SPLITTER);
				
				//no enclosing area
				if(temp.length == 2) {
					Controller.list.add(new Area(Integer.parseInt(temp[0]),
							temp[1]));
					
					//System.out.println("THE AREA IS -"+ temp[0] +"-"+temp[1]);
					
				}else {
					//has enclosing area
					
					Controller.list.add(new Area( Integer.parseInt(temp[0]),
							temp[1], (Area) Controller.list.getID(Integer.parseInt(temp[2]))));
				}
				
	
			}catch(Exception e) {
				//Incorrect formatting of file
				e.printStackTrace();
				continue;
			}
			
		}
		
	}
	
	private static void initializeTransferGates(File file){
		
		try {
			ini = new Scanner(file);
		} catch (FileNotFoundException e) {
			// FAILED TO FILD FILE
			e.printStackTrace();
			return;
		}
		
		String temp[];
		
		while(ini.hasNextLine()) {

			try {

				//Split line into elements
				temp = ini.nextLine().split(SPLITTER);
				
				//split coordinate field
				String[] tempCoordinates = temp[4].split(COORDINATE_SPLITTER);
				int[] coordinates = new int[tempCoordinates.length];
				for(int m=0; m< tempCoordinates.length; m++) {
					coordinates[m] = Integer.parseInt(tempCoordinates[m]);
				}
				
				Controller.list.add(new TransferGate(Integer.parseInt(temp[0]),
						temp[1], (Area) Controller.list.getID(Integer.parseInt(temp[2])),
								(Area) Controller.list.getID(Integer.parseInt(temp[3])),
								coordinates));
	
			}catch(Exception e) {
				//Incorrect formatting of file
				e.printStackTrace();
				continue;
			}
			
		}
		
	}
	
}
