package programLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sensors.Entity;
import sensors.Gate;
import sensors.IDable;
import sensors.Mobile;
import sensors.MobileActivityGate;
import sensors.StaticActivityGate;
import sensors.TransferGate;

public class programLoop {

	private static final String SPLITTER = "'";

	public static void main(String[] args) {

		//Initialize all Objects
		Initializer.initializeAll(args[0]);

		
		//variables used for the constant creation of Processed data
		//from raw data
		Scanner ini;
		File inputFile = new File(args[0]+"/CurrentRawData");
		ArrayList<String> tempOutput;
		File outputFile = new File(args[0]+"/ProcessedData");

		//System.out.println("THIS IS BEFORE LOOP");
		
		File newFile = new File(args[0]+"/FUCKYESMATE");
		
		//start program loop
		while(true) {

			//check if we have an input file
			if(! (inputFile.exists() && !inputFile.isDirectory()) ){
				try {
					//System.out.println("WE DID NOT FFIND THE FILE");
					Thread.sleep(1000);
					//sleep 1 second
				} catch (InterruptedException e) {
					//application had problems when sleeping
					e.printStackTrace();
				}
				continue;
			}
			
			//System.out.println("WE FOUND THE FILE");


			try {
				ini = new Scanner(inputFile);
				tempOutput = new ArrayList<String>();


				while(ini.hasNextLine()) {
					//Get Raw data lines in file
					String[] temp = ini.nextLine().split(SPLITTER);
					String temporaryLine="";
					
					//find Gate
					Gate gate = (Gate) Controller.list.getID(Integer.parseInt(temp[1]));
					//find Entity
					Entity entity = (Entity) Controller.list.getID(Integer.parseInt(temp[2]));
					
					//mobile went through door
					if(gate.isTransferGate()) {
						
						//CHECK IF AREA IS NULL
						if(entity.getArea() == null) {
							
							//area is outside or unlisted
							if(((TransferGate)gate).getAreas()[0] !=null){
								entity.changeArea(((TransferGate)gate).getAreas()[0]);
							}else {
								entity.changeArea(((TransferGate)gate).getAreas()[1]);
							}
							
						}else if(entity.getArea().equalTo(((TransferGate)gate).getAreas()[0])){
							entity.changeArea(((TransferGate)gate).getAreas()[1]);
						}else{
							entity.changeArea(((TransferGate)gate).getAreas()[0]);
						}
						
						if(!entity.isMobileActivityGate()) {
							//person is not doing an activity
							((Mobile)entity).setActivity(null);
						}
						
					}
					
					//System.out.println("1 " + entity.getArea().getName());

					//mobile is doing an activity
					if(gate.isMobileActivityGate() || gate.isStaticActivityGate()) {
						if(gate.isMobileActivityGate()) {
							//System.out.println("Mobile activity");
							entity.changeArea(((MobileActivityGate)gate).getArea());
						}else {
							//System.out.println("Static activity");
							entity.changeArea(((StaticActivityGate)gate).getArea());
						}
						if(!entity.isMobileActivityGate()) {
							//person is not doing an activity
							((Mobile)entity).setActivity(gate);
						}
					}

					//System.out.println("2 " + entity.getArea().getName());
					
					//save time stamp
					temporaryLine=temp[0]+SPLITTER;
					
					//Write Entity
					temporaryLine = temporaryLine + entity.getID() 
					+ SPLITTER + entity.getName();
					
					//Write Area
					if(entity.getArea() != null) {
						temporaryLine = temporaryLine + SPLITTER + entity.getArea().getID()
								+ SPLITTER + entity.getArea().getName();
					}else {
						////System.out.println("AREA WAS NULL");
					}
					
					//System.out.println("3 " + entity.getArea().getName());
					
					//Write Activity
					if(!entity.isMobileActivityGate()) {
						//person is not doing an activity
						if(((Mobile)entity).getActivity() != null) {
							temporaryLine = temporaryLine + SPLITTER + ((Mobile)entity).getActivity().getID()
									+ SPLITTER + ((Mobile)entity).getActivity().getName();
						}
					}
					
					//ADDED
					if(gate.isTransferGate()) {
						temporaryLine = temporaryLine + SPLITTER + gate.getID()
								+ SPLITTER + gate.getName();
					}
					
					//System.out.println("4 " + entity.getArea().getName());
					
					//add temporaryLine to tempOutput
					tempOutput.add(temporaryLine);
				}

				ini.close();
				
				//TO CHANGE
				inputFile.delete();	//WENEEDTHIS

				FileWriter fileWrite = new FileWriter(outputFile, true);
				
				//write tempOutput arrayList to output file
				for(String out : tempOutput) {
					fileWrite.write(out+"\n");
				}

				fileWrite.close();
				//break;	//TO CHANGE//

			} catch (FileNotFoundException e) {
				//Input was written incorrectly
				e.printStackTrace();
			}catch(IOException ex){
				//Output was written incorrectly
				ex.printStackTrace();
			}
		}


	}

}
