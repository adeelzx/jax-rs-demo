package com.adeel.demo.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.adeel.demo.model.Activity;

public class ActivityClientTest {

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("1234");
		
		System.out.println(activity);
		assertNotNull(activity);
	}
	
	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.get();
		
		System.out.println(activities);
		assertNotNull(activities);
	}
	
	@Test//(expected=RuntimeException.class)
	public void testGetWithBadRequest() {
		ActivityClient client = new ActivityClient();
		client.get("1");
	}
}
