package com.upload;


import com.filmservice.credential.CredentialDetail;
import com.filmservice.credential.RemoteApiSetup;
import com.filmservice.credential.TestCredentialImpl;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;


import java.io.IOException;


public class UploadData {
    public static void main(String[] args) throws IOException {
    	
    	new RemoteApiSetup();
        
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

            for(int counter = 0; counter <= 5000; ++counter){
            Entity movie = new Entity("movie");

            movie.setProperty("year", 1998);
            movie.setProperty("actors", "this are just test actors");

            System.out.println("Key of new entity is " + ds.put(movie)+", number: "+counter);
            }

    }
}
