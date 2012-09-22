package com.upload;


import com.filmservice.credential.RemoteApiSetup;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

import java.io.IOException;

public class RemoveData {
    public static void main(String[] args) throws IOException {
    	new RemoteApiSetup();
        
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

        for(int counter = 0; counter <= 5000; ++counter){
            Entity movie = new Entity("movie");

            System.out.println("Deleting "+movie.getKey());
            ds.delete(movie.getKey());

            }
        
    }
}
