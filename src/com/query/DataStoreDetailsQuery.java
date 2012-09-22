package com.query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.filmservice.credential.CredentialDetail;
import com.filmservice.credential.RemoteApiSetup;
import com.filmservice.credential.TestCredentialImpl;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class DataStoreDetailsQuery {
	
	private static final String KIND = "Movie";
	
	private String movieName;
	private String movieYear;
	
	static {
		new RemoteApiSetup();
	}
	
	public List<String> getNameDetails(){
		List<String> movieDetailsList = new ArrayList<String>();
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter nameFilter =  new FilterPredicate("name",FilterOperator.EQUAL, this.movieName);
		
		Query q = new Query(KIND).setFilter(nameFilter);
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			movieDetailsList.add(result.getProperty("name") + "," +
					result.getProperty("numberVoters") + "," +
					result.getProperty("rating") + "," +
					result.getProperty("year"));
		}

		System.out.println("Finished!");
		return movieDetailsList;

	}
	
	public List<String> getDetails(){

		List<String> movieDetailsList = new ArrayList<String>();
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter filter = new FilterPredicate("year",FilterOperator.EQUAL, movieYear);	
		
		Query q = new Query(KIND).setFilter(filter);
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			movieDetailsList.add(result.getProperty("name") + "," +
					result.getProperty("numberVoters") + "," +
					result.getProperty("rating") + "," +
					result.getProperty("year"));
		}

		System.out.println("Finished!");
		return movieDetailsList;

	}
	
	public void setMovieName(String movieName) {
		this.movieName = movieName.toUpperCase();
	}
	public void setMovieYear(String movieYear) {
		this.movieYear = movieYear;
	}

/*	Filter lastNameFilter =
			  new FilterPredicate("lastName",
			                      FilterOperator.EQUAL,
			                      targetLastName);

			Filter cityFilter =
			  new FilterPredicate("city",
			                      FilterOperator.EQUAL,
			                      targetCity);

			Filter birthYearMinFilter =
			  new FilterPredicate("birthYear",
			                      FilterOperator.GREATER_THAN_OR_EQUAL,
			                      minBirthYear);

			Filter birthYearMaxFilter =
			  new FilterPredicate("birthYear",
			                      FilterOperator.LESS_THAN_OR_EQUAL,
			                      maxBirthYear);

			Filter validFilter = CompositeFilterOperator.and(lastNameFilter,
			                                                 cityFilter,
			                                                 birthYearMinFilter,
			                                                 birthYearMaxFilter);

			Query q = new Query("Person").setFilter(validFilter);*/
}
