package com.adeel.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.adeel.demo.model.Activity;
import com.adeel.demo.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	/* (non-Javadoc)
	 * @see com.adeel.demo.repository.ActivityRepository#findAllActivities()
	 */
	@Override
	public List<Activity> findAllActivities() {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setActivityId("1234");
		activity1.setDescription("First Activity");
		activity1.setDuration(45);
		
		Activity activity2 = new Activity();
		activity1.setActivityId("5678");
		activity2.setDescription("Second Activity");
		activity2.setDuration(90);
		
		activities.add(activity1);
		activities.add(activity2);
		
		return activities;
	}

	@Override
	public Activity findActivity(String activityId) {
		
		if(activityId.equals("1111")) {
			return null;
		}
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setActivityId("1234");
		activity1.setDescription("First Activity");
		activity1.setDuration(45);
		
		Activity activity2 = new Activity();
		activity1.setActivityId("5678");
		activity2.setDescription("Second Activity");
		activity2.setDuration(90);
		
		User user = new User();
		user.setId("acism");
		user.setName("Adeel Ahmad");
		
		activity1.setUser(user);
		activity2.setUser(user);
		activities.add(activity1);
		activities.add(activity2);
		
		Activity activity = new Activity();
		boolean isExist = false;
		for(Activity a : activities ) {
			
			if(a.getActivityId().equals(activityId))
				isExist = true;
			if(isExist)
			return a;	
			
			
		}
		
		return activity;
	}

	@Override
	public void createActivity(Activity activity) {
		// TODO Auto-generated method stub
		
	}
}
