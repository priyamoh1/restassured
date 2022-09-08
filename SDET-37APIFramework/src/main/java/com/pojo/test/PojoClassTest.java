package com.pojo.test;

public class PojoClassTest 
{
String projectName;
String createdBy;
String createdOn;
String status;
int teamSize;
public PojoClassTest(String projectName, String createdBy, String createdOn, String status, int teamSize) {
	super();
	this.projectName = projectName;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.status = status;
	this.teamSize = teamSize;
}
PojoClassTest()
{
	
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(String createdOn) {
	this.createdOn = createdOn;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getTeamSize() {
	return teamSize;
}
public void setTeamSize(int teamSize) {
	this.teamSize = teamSize;
}
	
}
