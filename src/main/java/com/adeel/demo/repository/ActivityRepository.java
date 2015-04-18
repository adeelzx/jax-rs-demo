package com.adeel.demo.repository;

import java.util.List;

import com.adeel.demo.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void createActivity(Activity activity);

}