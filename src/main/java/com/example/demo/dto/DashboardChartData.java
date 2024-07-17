package com.example.demo.dto;

public class DashboardChartData {
    private String[] departments;
    private int[] totalData;
    private int[] closedData;   
    
    public DashboardChartData(int[] totalData, int[] closedData) {
        this.setDepartments(departments);
        this.totalData = totalData;
        this.closedData = closedData;
    }

    public int[] getTotalData() {
        return totalData;
    }

    public void setTotalData(int[] totalData) {
        this.totalData = totalData;
    }

    public int[] getClosedData() {
        return closedData;
    }

    public void setClosedData(int[] closedData) {
        this.closedData = closedData;
    }

	public String[] getDepartments() {
		return departments;
	}

	public void setDepartments(String[] departments) {
		this.departments = departments;
	}
}
