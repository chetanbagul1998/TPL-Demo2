package com.example.demo.model;

public class CounterResponse {

    private int totalProjects;
    private int closedProjects;
    private int runningProjects;
    private int cancelledProjects;
	public CounterResponse(int totalProjects, int closedProjects, int runningProjects, int cancelledProjects) {
		super();
		this.totalProjects = totalProjects;
		this.closedProjects = closedProjects;
		this.runningProjects = runningProjects;
		this.cancelledProjects = cancelledProjects;
	}
	public int getTotalProjects() {
		return totalProjects;
	}
	public void setTotalProjects(int totalProjects) {
		this.totalProjects = totalProjects;
	}
	public int getClosedProjects() {
		return closedProjects;
	}
	public void setClosedProjects(int closedProjects) {
		this.closedProjects = closedProjects;
	}
	public int getRunningProjects() {
		return runningProjects;
	}
	public void setRunningProjects(int runningProjects) {
		this.runningProjects = runningProjects;
	}
	public int getCancelledProjects() {
		return cancelledProjects;
	}
	public void setCancelledProjects(int cancelledProjects) {
		this.cancelledProjects = cancelledProjects;
	}
    
}
