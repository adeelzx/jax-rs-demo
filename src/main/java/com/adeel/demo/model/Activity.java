package com.adeel.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {

	private String activityId;
	private String description;
	private int duration;
	private User user;

//	@XmlElement(name="desc")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
