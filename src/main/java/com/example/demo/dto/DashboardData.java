package com.example.demo.dto;

public class DashboardData {
    private long totalProjects;
    private long completedProjects;
    private long ongoingProjects;
    private long pendingProjects;

    public DashboardData(long totalProjects, long completedProjects, long ongoingProjects, long pendingProjects) {
        this.totalProjects = totalProjects;
        this.completedProjects = completedProjects;
        this.ongoingProjects = ongoingProjects;
        this.pendingProjects = pendingProjects;
    }

    public long getTotalProjects() {
        return totalProjects;
    }

    public void setTotalProjects(long totalProjects) {
        this.totalProjects = totalProjects;
    }

    public long getCompletedProjects() {
        return completedProjects;
    }

    public void setCompletedProjects(long completedProjects) {
        this.completedProjects = completedProjects;
    }

    public long getOngoingProjects() {
        return ongoingProjects;
    }

    public void setOngoingProjects(long ongoingProjects) {
        this.ongoingProjects = ongoingProjects;
    }

    public long getPendingProjects() {
        return pendingProjects;
    }

    public void setPendingProjects(long pendingProjects) {
        this.pendingProjects = pendingProjects;
    }
}
