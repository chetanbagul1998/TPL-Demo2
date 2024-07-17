package com.example.demo.dto;

public class DashboardCounters {
    private long totalProjects;
    private long closedProjects;
    private long runningProjects;
    private long closureDelay;
    private long cancelledProjects;

    public DashboardCounters(long totalProjects, long closedProjects, long runningProjects, long closureDelay, long cancelledProjects) {
        this.totalProjects = totalProjects;
        this.closedProjects = closedProjects;
        this.runningProjects = runningProjects;
        this.closureDelay = closureDelay;
        this.cancelledProjects = cancelledProjects;
    }

	public long getTotalProjects() {
		return totalProjects;
	}

	public void setTotalProjects(long totalProjects) {
		this.totalProjects = totalProjects;
	}

	public long getClosedProjects() {
		return closedProjects;
	}

	public void setClosedProjects(long closedProjects) {
		this.closedProjects = closedProjects;
	}

	public long getRunningProjects() {
		return runningProjects;
	}

	public void setRunningProjects(long runningProjects) {
		this.runningProjects = runningProjects;
	}

	public long getClosureDelay() {
		return closureDelay;
	}

	public void setClosureDelay(long closureDelay) {
		this.closureDelay = closureDelay;
	}

	public long getCancelledProjects() {
		return cancelledProjects;
	}

	public void setCancelledProjects(long cancelledProjects) {
		this.cancelledProjects = cancelledProjects;
	}
    
}






    

//    public long getTotalProjects() {
//        return totalProjects;
//    }
//
//    public void setTotalProjects(long totalProjects) {
//        this.totalProjects = totalProjects;
//    }
//
//    public long getClosedProjects() {
//        return closedProjects;
//    }
//
//    public void setClosedProjects(long closedProjects) {
//        this.closedProjects = closedProjects;
//    }
//
//    public long getRunningProjects() {
//        return runningProjects;
//    }
//
//    public void setRunningProjects(long runningProjects) {
//        this.runningProjects = runningProjects;
//    }
//
//    public long getRunningProjectsWithEndDateBeforeToday() {
//    	return closureDelay;
//    }
//
//    public void setRunningProjectsWithEndDateBeforeToday(long closureDelay) {
//    	this.closureDelay = closureDelay;
//    }
//
//    public long getCancelledProjects() {
//        return cancelledProjects;
//    }
//
//    public void setCancelledProjects(long cancelledProjects) {
//        this.cancelledProjects = cancelledProjects;
//    }

