package com.query;

import java.util.List;

public class TestDataStoreQuery {
	
	public static void main(String args[]){
		DataStoreDetailsQuery d = new DataStoreDetailsQuery();
		d.setMovieYear("1998");
		
		/**
		 * TODO
		 * Need to give the full name of film as specified in CSV file, update to find film based on name
		 * only
		 */
		d.setMovieName("they come to AmeriCA");
		
		/*List<String> details = d.getDetails();*/
		List<String> details = d.getNameDetails();
		for(String detail : details){
			System.out.println("Detail is "+detail);
		}
		
		System.exit(0);
	}

}
