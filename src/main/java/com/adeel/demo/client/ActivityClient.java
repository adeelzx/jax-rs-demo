package com.adeel.demo.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.adeel.demo.model.Activity;
 
public class ActivityClient {
	
	private Client client;
	
	public ActivityClient() {
		client = ClientBuilder.newClient();
	}

	public Activity get(String id) {
		WebTarget target = client.target("http://localhost:8080/adeel-services/webapi/");
		Response response = target.path("activities/"+id).request().get(Response.class);
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": Error on server !");
		}
		return response.readEntity(Activity.class);
	}
	
	public List<Activity> get() {
		WebTarget target = client.target("http://localhost:8080/adeel-services/webapi/");
		List<Activity> activities = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
		return activities;
	}
}
