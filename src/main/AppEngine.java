package main;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import database.MarkerSQLProvider;
import database.PhoneDatabase;
import database.SQLProvider;
import entity.Marker;
import entity.Phone;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.//logger;


public class AppEngine {
	
    private static Logger logger =
    		LogManager.getLogger(AppEngine.class);
	
	public static void main(String[] args) {
//        logger.trace("Tracking the excecution flow");
//        logger.debug("I'm trying to identify an issue");
//        logger.info("General information message");
//        logger.warn("Something happened we should consider");
//        logger.error(new RuntimeException("An error occurred"));
//        logger.fatal("Very serious, let application crash");
		//runMarkerSQLProviderExample();
		
		PhoneDatabase db = new PhoneDatabase();
		int recordsAffected = 
				db.add(new Phone(0,"BLU",30f));
		if(recordsAffected == 1) {
			System.out.println("BLU phone added successfully");
		}else {
			System.out.println("BlU phone was not added");
		}
		recordsAffected = 
				db.add(new Phone(0,"Samsung",30f));
		if(recordsAffected == 1) {
			System.out.println("Samsung phone added successfully");
		}else {
			System.out.println("Samsung phone was not added");
		}
		List<Phone> results = db.selectAll();
		
		for(Phone phone : results) {
			System.out.println(phone);
		}


	}

	private static void runMarkerSQLProviderExample() {
		final String SUFFIX = " updated ";
		
		//Create new instance of provider
		SQLProvider<Marker> markerSQLProvider = new MarkerSQLProvider(); 
		
		Marker testMarker = new Marker(1,"blue");
		//add a new marker
		markerSQLProvider.add(testMarker);
		
		testMarker.setName("red");
		markerSQLProvider.add(testMarker);
		
		//retrieve all markers
		List<Marker> markers = markerSQLProvider.selectAll();
		
		int recordsAffected = 0;
		
		for(Marker m : markers){
			//logger.info("Marker : "+m);
			
			m.setName(m.getName()+SUFFIX);
			
			//update an existing marker
			recordsAffected = markerSQLProvider.update(m, m.getId());
			//logger.info("After updating marker, records affected : "+recordsAffected);
					
		}	
		
		//retrieve a specific marker
		testMarker = markerSQLProvider.get(markers.get(0).getId());
		//logger.info("Retrieved marker with id "+markers.get(0).getId());
		//logger.info(testMarker.toString());
		
		
		//delete all markers
		/*
		for(Marker m : markers){
			
			//delete an existing marker
			recordsAffected = markerSQLProvider.delete(m.getId());
			//logger.info("After deleting marker, records affected : "+recordsAffected);		
			
		}
		*/
		
		//logger.info("Database Demo complete");
			
		
	}

}
