package com.adeel.demo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.adeel.demo.model.Activity;
import com.adeel.demo.model.User;
import com.adeel.demo.repository.ActivityRepository;
import com.adeel.demo.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityResource {

	private ActivityRepository acitivityRepository = new ActivityRepositoryStub();
	
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Activity createActivity(Activity activity) {
		
		acitivityRepository.createActivity(activity);
		return activity;
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
		
		Activity activity = new Activity();
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		
		acitivityRepository.createActivity(activity);
		return activity;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities() {
		return acitivityRepository.findAllActivities();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{activityId}")
	public Response getActivity(@PathParam("activityId") String activityId) {
		
		if(activityId == null || activityId.length() < 2) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Activity activity = acitivityRepository.findActivity(activityId);
		
		if(activity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(activity).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{activityId}/a")
	public User getUser(@PathParam("activityId") String activityId) {
		return acitivityRepository.findActivity(activityId).getUser();
	}
}
